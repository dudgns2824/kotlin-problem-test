package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.query

import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.query.IPrescriptionCodeDomainQueryServiceBus
import org.springframework.stereotype.Service

@Service
class PrescriptionCodeDomainQueryService : IPrescriptionCodeDomainQueryServiceBus {
    override fun prescriptionCodeIsActivate(prescriptionCode: String) = true
}