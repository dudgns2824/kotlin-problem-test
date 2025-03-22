package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.query

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.prescription.exception.DomainPrescriptionErrCode
import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.query.IPrescriptionCodeDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.query.IPrescriptionCodeDomainQueryServiceBus
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PrescriptionCodeDomainQueryService(
    private val prescriptionCodeDomainQueryRepositoryBus: IPrescriptionCodeDomainQueryRepositoryBus,
) : IPrescriptionCodeDomainQueryServiceBus {
    override fun prescriptionCodeIsActivate(prescriptionCode: String) =
        prescriptionCodeDomainQueryRepositoryBus.prescriptionCodeIsActivate(prescriptionCode)

    override fun getPrescriptionCodeDetail(id: String) =
        prescriptionCodeDomainQueryRepositoryBus.getDetailPrescriptionCode(id)

    override fun verifyUserPrescriptionCodeCheck(prescriptionCode: String): Boolean {
        val prescriptionCodeDetail =
            prescriptionCodeDomainQueryRepositoryBus.getDetailPrescriptionCode(prescriptionCode)

        // 유저가 처방 코드가 등록 될때 정상 적인 로직이면 탈 일은 없지만 혹시 몰라 추가
        if (prescriptionCodeDetail.expiredAt == null) {
            throw byndMdcnException(DomainPrescriptionErrCode.PRESCRIPTION_CODE_NOT_REGISTER)
        }

        // 처방 코드 만료
        if (prescriptionCodeDetail.expiredAt!!.isBefore(LocalDateTime.now())) {
            throw byndMdcnException(DomainPrescriptionErrCode.PRESCRIPTION_CODE_EXPIRED)
        }

        return true
    }
}
