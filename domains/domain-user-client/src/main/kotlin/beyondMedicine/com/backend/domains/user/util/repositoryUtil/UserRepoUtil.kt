package beyondMedicine.com.backend.domains.user.util.repositoryUtil

import beyondMedicine.com.backend.domains.user.dto.user.response.UserDetailResponseDto
import beyondMedicine.com.backend.domains.user.entity.QUserEntity.userEntity
import com.querydsl.core.types.ConstructorExpression
import com.querydsl.core.types.Projections

object UserRepoUtil {
    fun ceUserDetail(): ConstructorExpression<UserDetailResponseDto> =
        Projections.constructor(
            UserDetailResponseDto::class.java,
            userEntity.userId,
            userEntity.prescriptionCode,
            userEntity.createdAt,
            userEntity.updatedAt,
            userEntity.deletedAt,
        )
}
