package beyondMedicine.com.backend.domains.user.servicebus.version.query

import beyondMedicine.com.backend.domains.user.dto.version.response.VersionDetailResponseDto

interface IVersionDomainQueryServiceBus {
    fun getVersionDetail(
        os: String,
        mode: String,
    ): VersionDetailResponseDto
}
