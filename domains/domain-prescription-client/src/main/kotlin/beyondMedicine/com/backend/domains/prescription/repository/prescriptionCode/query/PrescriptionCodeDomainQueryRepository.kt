package beyondMedicine.com.backend.domains.prescription.repository.prescriptionCode.query

import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.query.IPrescriptionCodeDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.prescription.util.BaseRepository
import org.springframework.stereotype.Repository

@Repository
class PrescriptionCodeDomainQueryRepository: BaseRepository(), IPrescriptionCodeDomainQueryRepositoryBus {
    override fun prescriptionCodeIsActivate(prescriptionCode: String) = TODO("Not yet implemented")
}