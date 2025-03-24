package beyondMedicine.com.backend.serviceBus.user.query

import beyondMedicine.com.backend.dto.user.request.VerifyUserRequestDto

interface IBackendUserQueryServiceBus {
    fun verifyUser(req: VerifyUserRequestDto): String
}
