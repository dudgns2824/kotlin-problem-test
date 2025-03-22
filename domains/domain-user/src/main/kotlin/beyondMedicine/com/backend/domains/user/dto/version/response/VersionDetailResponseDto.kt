package beyondMedicine.com.backend.domains.user.dto.version.response

data class VersionDetailResponseDto(
    val recentVersion: String,
    val minVersion: String,
    val os: String,
    val mode: String,
    val hash: String,
)
