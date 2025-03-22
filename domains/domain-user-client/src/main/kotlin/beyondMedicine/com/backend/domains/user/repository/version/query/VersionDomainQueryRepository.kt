package beyondMedicine.com.backend.domains.user.repository.version.query

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.user.entity.QVersionEntity.versionEntity
import beyondMedicine.com.backend.domains.user.exception.DomainUserErrCode
import beyondMedicine.com.backend.domains.user.repositorybus.version.query.IVersionDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.user.util.BaseRepository
import beyondMedicine.com.backend.domains.user.util.repositoryUtil.version.VersionRepoUtil
import org.springframework.stereotype.Repository

@Repository
class VersionDomainQueryRepository :
    BaseRepository(),
    IVersionDomainQueryRepositoryBus {
    override fun getVersion(
        os: String,
        mode: String,
    ) = queryFactory
        .select(VersionRepoUtil.ceVersionDetail())
        .from(versionEntity)
        .where(
            versionEntity.id.os.eq(os),
            versionEntity.id.mode.eq(mode),
        ).fetchOne() ?: throw byndMdcnException(DomainUserErrCode.VERSION_NOT_VALID)
}
