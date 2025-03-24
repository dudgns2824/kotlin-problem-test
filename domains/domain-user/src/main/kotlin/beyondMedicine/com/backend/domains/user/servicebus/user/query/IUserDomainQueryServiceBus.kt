package beyondMedicine.com.backend.domains.user.servicebus.user.query

import beyondMedicine.com.backend.domains.user.dto.user.request.UserVerifyRequestDto
import beyondMedicine.com.backend.domains.user.dto.user.response.UserDetailResponseDto

interface IUserDomainQueryServiceBus {
    fun getUserDetail(id: String): UserDetailResponseDto

    fun verifyUser(req: UserVerifyRequestDto): String
}
