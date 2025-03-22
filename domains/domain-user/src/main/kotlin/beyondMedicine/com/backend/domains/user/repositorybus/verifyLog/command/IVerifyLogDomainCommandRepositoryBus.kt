package beyondMedicine.com.backend.domains.user.repositorybus.verifyLog.command

import beyondMedicine.com.backend.domains.user.dto.verifyLog.request.CreateVerifyLogRequestDto

interface IVerifyLogDomainCommandRepositoryBus {
    fun createVerifyLog(req: CreateVerifyLogRequestDto): Boolean
}