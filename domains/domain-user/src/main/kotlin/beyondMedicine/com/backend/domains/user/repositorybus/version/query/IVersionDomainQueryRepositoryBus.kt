package beyondMedicine.com.backend.domains.user.repositorybus.version.query

import beyondMedicine.com.backend.domains.user.dto.version.response.VersionDetailResponseDto

interface IVersionDomainQueryRepositoryBus {
    fun getVersion(
        os: String,
        mode: String,
    ): VersionDetailResponseDto
}
