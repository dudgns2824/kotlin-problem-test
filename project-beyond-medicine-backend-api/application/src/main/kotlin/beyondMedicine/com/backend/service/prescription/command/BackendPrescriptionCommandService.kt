package beyondMedicine.com.backend.service.prescription.command

import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.command.IPrescriptionCodeDomainCommandServiceBus
import org.springframework.stereotype.Service
import beyondMedicine.com.backend.serviceBus.prescription.command.IBackendPrescriptionCommandServiceBus

@Service
class BackendPrescriptionCommandService(
    private val prescriptionCodeDomainCommandServiceBus: IPrescriptionCodeDomainCommandServiceBus
) : IBackendPrescriptionCommandServiceBus {
    override fun createPrescriptionCode(hospitalId: String) =
        prescriptionCodeDomainCommandServiceBus.createPrescriptionCode(hospitalId)

    override fun activatePrescription(userId: String, prescriptionCode: String) =
        prescriptionCodeDomainCommandServiceBus.activatePrescription(userId, prescriptionCode)
}