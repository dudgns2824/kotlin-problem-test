package beyondMedicine.com.backend.domains.user.repositorybus.user.query

import beyondMedicine.com.backend.domains.user.dto.response.UserDetailResponseDto

interface IUserDomainQueryRepositoryBus {
    fun getUserDetail(id: String): UserDetailResponseDto?
}
