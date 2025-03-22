package beyondMedicine.com.backend.domains.user.servicebus.verifyLog.command

import beyondMedicine.com.backend.domains.user.dto.verifyLog.request.CreateVerifyLogRequestDto

interface IVerifyLogDomainCommandServiceBus {
    fun createVerifyLog(req: CreateVerifyLogRequestDto): Boolean
}