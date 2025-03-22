package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.command

import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.command.IPrescriptionCodeDomainCommandRepositoryBus
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.command.IPrescriptionCodeDomainCommandServiceBus
import org.springframework.stereotype.Service

@Service
class PrescriptionCodeDomainCommandService(
    private val prescriptionCodeDomainCommandRepositoryBus: IPrescriptionCodeDomainCommandRepositoryBus
) : IPrescriptionCodeDomainCommandServiceBus {
    override fun createPrescriptionCode(hospitalId: String) =
        prescriptionCodeDomainCommandRepositoryBus.createPrescriptionCode(hospitalId)

    override fun activatePrescription(userId: String, prescriptionCode: String) =
        prescriptionCodeDomainCommandRepositoryBus.activatePrescription(userId, prescriptionCode)
}