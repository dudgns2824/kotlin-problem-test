package beyondMedicine.com.backend.serviceBus.user.command

import beyondMedicine.com.backend.dto.user.request.VerifyUserRequestDto

interface IBackendUserCommandServiceBus {
    fun verifyUser(req: VerifyUserRequestDto): String
}
