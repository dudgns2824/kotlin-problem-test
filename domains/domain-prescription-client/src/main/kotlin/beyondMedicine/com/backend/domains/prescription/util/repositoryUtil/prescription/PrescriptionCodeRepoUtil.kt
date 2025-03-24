package beyondMedicine.com.backend.domains.prescription.util.repositoryUtil.prescription

import beyondMedicine.com.backend.domains.prescription.dto.response.PrescriptionCodeDetailResponseDto
import beyondMedicine.com.backend.domains.prescription.entity.QPrescriptionCodeDomainEntity.prescriptionCodeDomainEntity
import com.querydsl.core.types.ConstructorExpression
import com.querydsl.core.types.Projections

object PrescriptionCodeRepoUtil {
    fun cePrescriptionCodeDetail(): ConstructorExpression<PrescriptionCodeDetailResponseDto> =
        Projections.constructor(
            PrescriptionCodeDetailResponseDto::class.java,
            prescriptionCodeDomainEntity.id,
            prescriptionCodeDomainEntity.hospitalId,
            prescriptionCodeDomainEntity.isActivate,
            prescriptionCodeDomainEntity.createdAt,
            prescriptionCodeDomainEntity.expiredAt,
            prescriptionCodeDomainEntity.updatedAt,
            prescriptionCodeDomainEntity.deletedAt,
        )
}
