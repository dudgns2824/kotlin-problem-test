package beyondMedicine.com.backend.domains.user.servicebus.user.query

import beyondMedicine.com.backend.domains.user.dto.response.UserDetailResponseDto

interface IUserDomainQueryServiceBus {
    fun getUserDetail(id: String): UserDetailResponseDto
}
