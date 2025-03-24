package beyondMedicine.com.backend.domains.prescription.repository.prescriptionCode.command

import beyondMedicine.com.backend.domains.prescription.entity.QPrescriptionCodeDomainEntity.prescriptionCodeDomainEntity
import beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.command.IPrescriptionCodeDomainCommandRepositoryBus
import beyondMedicine.com.backend.domains.prescription.util.BaseRepository
import beyondMedicine.com.backend.domains.prescription.util.PrescriptionCodeUtil
import org.springframework.stereotype.Repository

@Repository
class PrescriptionCodeDomainCommandRepository :
    BaseRepository(),
    IPrescriptionCodeDomainCommandRepositoryBus {
    override fun createPrescriptionCode(hospitalId: String): String {
        lateinit var prescriptionCode: String

        var isDuplication = true

        while (isDuplication) {
            prescriptionCode = PrescriptionCodeUtil.createPrescriptionCode()

            isDuplication = queryFactory
                .select(prescriptionCodeDomainEntity.id)
                .from(prescriptionCodeDomainEntity)
                .where(prescriptionCodeDomainEntity.id.eq(prescriptionCode))
                .fetchOne() != null
        }

        queryFactory
            .insert(prescriptionCodeDomainEntity)
            .columns(
                prescriptionCodeDomainEntity.id,
                prescriptionCodeDomainEntity.hospitalId,
                prescriptionCodeDomainEntity.isActivate,
            ).values(
                prescriptionCode,
                hospitalId,
                false,
            ).execute() > 0

        return prescriptionCode
    }

    override fun activatePrescriptionCode(
        userId: String,
        prescriptionCode: String,
    ): Boolean {
        TODO("Not yet implemented")
    }
}
