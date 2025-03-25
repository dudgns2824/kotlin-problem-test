package beyondMedicine.com.backend.domains.prescription.repository.prescriptionCode

import beyondMedicine.com.backend.domains.prescription.entity.PrescriptionCodeDomainEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PrescriptionCodeJpaRepository : JpaRepository<PrescriptionCodeDomainEntity, String>
