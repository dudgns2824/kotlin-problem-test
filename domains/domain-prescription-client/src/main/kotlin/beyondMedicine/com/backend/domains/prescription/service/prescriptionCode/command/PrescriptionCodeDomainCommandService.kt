package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.command

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.prescription.exception.DomainPrescriptionErrCode
import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.command.IPrescriptionCodeDomainCommandRepositoryBus
import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.query.IPrescriptionCodeDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.command.IPrescriptionCodeDomainCommandServiceBus
import beyondMedicine.com.backend.domains.user.servicebus.user.command.IUserDomainCommandServiceBus
import beyondMedicine.com.backend.domains.user.servicebus.user.query.IUserDomainQueryServiceBus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
@Transactional
class PrescriptionCodeDomainCommandService(
    private val prescriptionCodeDomainCommandRepositoryBus: IPrescriptionCodeDomainCommandRepositoryBus,
    private val prescriptionCodeDomainQueryRepositoryBus: IPrescriptionCodeDomainQueryRepositoryBus,
    private val userDomainCommandServiceBus: IUserDomainCommandServiceBus,
    private val userDomainQueryServiceBus: IUserDomainQueryServiceBus,
) : IPrescriptionCodeDomainCommandServiceBus {
    override fun createPrescriptionCode(hospitalId: String) = prescriptionCodeDomainCommandRepositoryBus.createPrescriptionCode(hospitalId)

    override fun activatePrescriptionCode(
        userId: String,
        prescriptionCode: String,
    ): Boolean {
        val userDto = userDomainQueryServiceBus.getUserDetail(userId)

        // if 사용자가 처방코드를 등록한 상태.
        if (userDto.prescriptionCode != null) {
            val prescriptionCodeDto =
                prescriptionCodeDomainQueryRepositoryBus.getDetailPrescriptionCode(userDto.prescriptionCode)

            // 기존 처방코드가 만료되었을 때만 활성화할 수 있어요
            if (prescriptionCodeDto.expiredAt != null &&
                prescriptionCodeDto.expiredAt!!.isAfter(LocalDateTime.now())
            ) {
                // 사용자의 만료되지 않은 처방코드가 이미 등록되어 있음 exception 출력
                throw byndMdcnException(DomainPrescriptionErrCode.ACTIVATE_CONDITION_NOT_SATISFIED)
            }
        }

        // 유저의 처방 코드 업데이트
        userDomainCommandServiceBus.updateUserPrescriptionCode(userId, prescriptionCode)

        // 유저의 처방코드 활성화 만료 일자 6주 되는 날 자정
        return prescriptionCodeDomainCommandRepositoryBus.activatePrescriptionCode(userId, prescriptionCode)
    }
}
