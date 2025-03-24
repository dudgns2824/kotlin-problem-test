package beyondMedicine.com.backend.domains.user.service.user.query

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.user.dto.user.request.UserVerifyRequestDto
import beyondMedicine.com.backend.domains.user.exception.DomainUserErrCode
import beyondMedicine.com.backend.domains.user.repositorybus.user.query.IUserDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.user.repositorybus.version.query.IVersionDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.user.servicebus.user.query.IUserDomainQueryServiceBus
import beyondMedicine.com.backend.domains.user.util.VersionVerifyUtil
import org.springframework.stereotype.Service

@Service
class UserDomainQueryService(
    private val userDomainQueryRepositoryBus: IUserDomainQueryRepositoryBus,
    private val versionDomainQueryRepositoryBus: IVersionDomainQueryRepositoryBus,
) : IUserDomainQueryServiceBus {
    override fun getUserDetail(id: String) =
        userDomainQueryRepositoryBus.getUserDetail(id) ?: throw byndMdcnException(
            DomainUserErrCode.USER_NOT_EXIST,
        )

    override fun verifyUser(req: UserVerifyRequestDto): String {
        val versionDetail = versionDomainQueryRepositoryBus.getVersion(req.os, req.mode)

        VersionVerifyUtil.verifyVersion(req.version, versionDetail.recentVersion)
        VersionVerifyUtil.verifyVersion(req.version, versionDetail.minVersion)
        return ""
    }
}
