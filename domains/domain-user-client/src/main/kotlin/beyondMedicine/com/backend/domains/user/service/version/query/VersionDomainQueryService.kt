package beyondMedicine.com.backend.domains.user.service.version.query

import beyondMedicine.com.backend.domains.user.repositorybus.version.query.IVersionDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.user.servicebus.version.query.IVersionDomainQueryServiceBus
import org.springframework.stereotype.Service

@Service
class VersionDomainQueryService(
    private val versionDomainQueryRepositoryBus: IVersionDomainQueryRepositoryBus,
) : IVersionDomainQueryServiceBus {
    override fun getVersionDetail(
        os: String,
        mode: String,
    ) = versionDomainQueryRepositoryBus.getVersion(os, mode)
}
