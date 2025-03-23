package beyondMedicine.com.backend.domains.prescription.repository.prescriptionCode.query

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.prescription.entity.QPrescriptionCodeDomainEntity.prescriptionCodeDomainEntity
import beyondMedicine.com.backend.domains.prescription.exception.DomainPrescriptionErrCode
import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.query.IPrescriptionCodeDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.prescription.util.BaseRepository
import org.springframework.stereotype.Repository

@Repository
class PrescriptionCodeDomainQueryRepository : BaseRepository(), IPrescriptionCodeDomainQueryRepositoryBus {
    override fun prescriptionCodeIsActivate(prescriptionCode: String) =
        queryFactory
            .select(prescriptionCodeDomainEntity.isActivate)
            .from(prescriptionCodeDomainEntity)
            .where(prescriptionCodeDomainEntity.id.eq(prescriptionCode))
            .fetchOne() ?: throw byndMdcnException(DomainPrescriptionErrCode.PRESCRIPTION_NOT_EXIST)
}