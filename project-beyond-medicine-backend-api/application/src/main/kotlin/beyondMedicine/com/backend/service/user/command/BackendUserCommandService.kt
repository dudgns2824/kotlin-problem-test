package beyondMedicine.com.backend.service.user.command

import beyondMedicine.com.backend.domains.user.dto.user.request.UserVerifyRequestDto
import beyondMedicine.com.backend.domains.user.dto.verifyLog.request.CreateVerifyLogRequestDto
import beyondMedicine.com.backend.domains.user.servicebus.user.query.IUserDomainQueryServiceBus
import beyondMedicine.com.backend.domains.user.servicebus.verifyLog.command.IVerifyLogDomainCommandServiceBus
import beyondMedicine.com.backend.dto.user.request.VerifyUserRequestDto
import beyondMedicine.com.backend.serviceBus.user.command.IBackendUserCommandServiceBus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BackendUserCommandService (
    private val userDomainQueryServiceBus: IUserDomainQueryServiceBus,
    private val verifyLogDomainCommandServiceBus: IVerifyLogDomainCommandServiceBus
) : IBackendUserCommandServiceBus {
    override fun verifyUser(req: VerifyUserRequestDto): String {
        // 에러 데이터여도 요청 했다는 기록 남기기 위해 로그 먼저
        verifyLogDomainCommandServiceBus.createVerifyLog(
            CreateVerifyLogRequestDto(
                version = req.version,
                os = req.os,
                mode = req.mode,
                hash = req.hash,
            )
        )

        val resStr = userDomainQueryServiceBus.verifyUser(
            UserVerifyRequestDto(
                userId = req.userId,
                version = req.version,
                os = req.os,
                mode = req.mode,
                hash = req.hash,
            ),
        )

        return resStr
    }
}

