package beyondMedicine.com.backend.domains.user.service.verifyLog.command

import beyondMedicine.com.backend.domains.user.dto.verifyLog.request.CreateVerifyLogRequestDto
import beyondMedicine.com.backend.domains.user.repositorybus.verifyLog.command.IVerifyLogDomainCommandRepositoryBus
import beyondMedicine.com.backend.domains.user.servicebus.verifyLog.command.IVerifyLogDomainCommandServiceBus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class VerifyLogDomainCommandService(
    private val verifyLogDomainCommandRepositoryBus: IVerifyLogDomainCommandRepositoryBus
) : IVerifyLogDomainCommandServiceBus {
    override fun createVerifyLog(req: CreateVerifyLogRequestDto) =
        verifyLogDomainCommandRepositoryBus.createVerifyLog(req)
}