package beyondMedicine.com.backend.domains.user.util.repositoryUtil.version

import beyondMedicine.com.backend.domains.user.dto.version.response.VersionDetailResponseDto
import beyondMedicine.com.backend.domains.user.entity.QVersionEntity.versionEntity
import com.querydsl.core.types.ConstructorExpression
import com.querydsl.core.types.Projections

object VersionRepoUtil {
    fun ceVersionDetail(): ConstructorExpression<VersionDetailResponseDto> =
        Projections.constructor(
            VersionDetailResponseDto::class.java,
            versionEntity.id.recentVersion,
            versionEntity.id.minVersion,
            versionEntity.id.os,
            versionEntity.id.mode,
            versionEntity.id.hash,
        )
}
