package beyondMedicine.com.backend.service.user.query

import beyondMedicine.com.backend.domains.user.dto.user.request.UserVerifyRequestDto
import beyondMedicine.com.backend.domains.user.servicebus.user.query.IUserDomainQueryServiceBus
import beyondMedicine.com.backend.dto.user.request.VerifyUserRequestDto
import beyondMedicine.com.backend.serviceBus.user.query.IBackendUserQueryServiceBus
import org.springframework.stereotype.Service

@Service
class BackendUserQueryService(
    private val userDomainQueryServiceBus: IUserDomainQueryServiceBus,
) : IBackendUserQueryServiceBus {
    override fun verifyUser(req: VerifyUserRequestDto) =
        userDomainQueryServiceBus.verifyUser(
            UserVerifyRequestDto(
                userId = req.userId,
                version = req.version,
                os = req.os,
                mode = req.mode,
                hash = req.hash,
            ),
        )
}
