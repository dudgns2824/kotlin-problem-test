package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.command

import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.command.IPrescriptionCodeDomainCommandRepositoryBus
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.command.IPrescriptionCodeDomainCommandServiceBus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PrescriptionCodeDomainCommandService(
    private val prescriptionCodeDomainCommandRepositoryBus: IPrescriptionCodeDomainCommandRepositoryBus,
) : IPrescriptionCodeDomainCommandServiceBus {
    override fun createPrescriptionCode(hospitalId: String) = prescriptionCodeDomainCommandRepositoryBus.createPrescriptionCode(hospitalId)

    override fun activatePrescriptionCode(
        userId: String,
        prescriptionCode: String,
    ) = prescriptionCodeDomainCommandRepositoryBus.activatePrescriptionCode(userId, prescriptionCode)
}
