package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.query

import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.query.IPrescriptionCodeDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.query.IPrescriptionCodeDomainQueryServiceBus
import org.springframework.stereotype.Service

@Service
class PrescriptionCodeDomainQueryService(
    private val prescriptionCodeDomainQueryRepositoryBus: IPrescriptionCodeDomainQueryRepositoryBus
) : IPrescriptionCodeDomainQueryServiceBus {
    override fun prescriptionCodeIsActivate(prescriptionCode: String) =
        prescriptionCodeDomainQueryRepositoryBus.prescriptionCodeIsActivate(prescriptionCode)
}