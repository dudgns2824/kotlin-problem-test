package beyondMedicine.com.backend.domains.user.repositorybus.user.query

import beyondMedicine.com.backend.domains.user.dto.user.response.UserDetailResponseDto

interface IUserDomainQueryRepositoryBus {
    fun getUserDetail(id: String): UserDetailResponseDto?
}
