package beyondMedicine.com.backend.domains.prescription.repository.prescriptionCode.command

import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.command.IPrescriptionCodeDomainCommandRepositoryBus
import beyondMedicine.com.backend.domains.prescription.util.BaseRepository
import org.springframework.stereotype.Repository

@Repository
class PrescriptionCodeDomainCommandRepository: BaseRepository(), IPrescriptionCodeDomainCommandRepositoryBus {
    override fun createPrescriptionCode(hospitalId: String): String {
        TODO("Not yet implemented")
    }

    override fun activatePrescription(userId: String, prescriptionCode: String): Boolean {
        TODO("Not yet implemented")
    }
}