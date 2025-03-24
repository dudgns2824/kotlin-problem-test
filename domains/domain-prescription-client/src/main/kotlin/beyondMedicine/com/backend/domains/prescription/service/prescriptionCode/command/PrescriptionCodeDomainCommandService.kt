package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.command

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.prescription.exception.DomainPrescriptionErrCode
import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.command.IPrescriptionCodeDomainCommandRepositoryBus
import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.query.IPrescriptionCodeDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.command.IPrescriptionCodeDomainCommandServiceBus
import beyondMedicine.com.backend.domains.user.servicebus.user.query.IUserDomainQueryServiceBus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
@Transactional
class PrescriptionCodeDomainCommandService(
    private val prescriptionCodeDomainCommandRepositoryBus: IPrescriptionCodeDomainCommandRepositoryBus,
    private val prescriptionCodeDomainQueryRepositoryBus: IPrescriptionCodeDomainQueryRepositoryBus,
    private val userDomainQueryServiceBus: IUserDomainQueryServiceBus,
) : IPrescriptionCodeDomainCommandServiceBus {
    override fun createPrescriptionCode(hospitalId: String) = prescriptionCodeDomainCommandRepositoryBus.createPrescriptionCode(hospitalId)

    override fun activatePrescriptionCode(
        userId: String,
        prescriptionCode: String,
    ): Boolean {
        val userDto = userDomainQueryServiceBus.getUserDetail(userId)

        val prescriptionCodeDto =
            prescriptionCodeDomainQueryRepositoryBus.getDetailPrescriptionCode(userDto.prescriptionCode)

        // 기존 처방코드가 만료되었을 때만 활성화할 수 있어요
        if (prescriptionCodeDto.expiredAt != null &&
            prescriptionCodeDto.expiredAt!!.isAfter(LocalDateTime.now())
        ) {
            // 사용자의 만료되지 않은 처방코드가 이미 등록되어 있음
            if (userDto.prescriptionCode != null) {
                throw byndMdcnException(DomainPrescriptionErrCode.ACTIVATE_CONDITION_NOT_SATISFIED)
            } else {
                throw byndMdcnException(DomainPrescriptionErrCode.PRESCRIPTION_CODE_NOT_EXPIRED)
            }
        }

        return prescriptionCodeDomainCommandRepositoryBus.activatePrescriptionCode(userId, prescriptionCode)
    }
}
