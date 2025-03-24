package beyondMedicine.com.backend.domains.user.service.user.query

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.user.exception.DomainUserErrCode
import beyondMedicine.com.backend.domains.user.repositorybus.user.query.IUserDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.user.servicebus.user.query.IUserDomainQueryServiceBus
import org.springframework.stereotype.Service

@Service
class UserDomainQueryService(
    private val userDomainQueryRepositoryBus: IUserDomainQueryRepositoryBus,
) : IUserDomainQueryServiceBus {
    override fun getUserDetail(id: String) =
        userDomainQueryRepositoryBus.getUserDetail(id) ?: throw byndMdcnException(
            DomainUserErrCode.USER_NOT_EXIST,
        )
}
