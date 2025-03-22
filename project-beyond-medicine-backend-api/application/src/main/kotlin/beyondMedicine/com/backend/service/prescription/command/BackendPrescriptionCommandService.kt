package beyondMedicine.com.backend.service.prescription.command

import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.command.IPrescriptionCodeDomainCommandServiceBus
import beyondMedicine.com.backend.serviceBus.prescription.command.IBackendPrescriptionCommandServiceBus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BackendPrescriptionCommandService(
    private val prescriptionCodeDomainCommandServiceBus: IPrescriptionCodeDomainCommandServiceBus,
) : IBackendPrescriptionCommandServiceBus {
    // 처방 코드 생성
    override fun createPrescriptionCode(hospitalId: String) = prescriptionCodeDomainCommandServiceBus.createPrescriptionCode(hospitalId)

    // 처방 코드 활성화
    override fun activatePrescriptionCode(
        userId: String,
        prescriptionCode: String,
    ) = prescriptionCodeDomainCommandServiceBus.activatePrescriptionCode(userId, prescriptionCode)
}
