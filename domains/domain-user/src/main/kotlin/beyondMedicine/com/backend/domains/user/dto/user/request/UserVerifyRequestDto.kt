package beyondMedicine.com.backend.domains.user.dto.user.request

data class UserVerifyRequestDto(
    val userId: String,
    val version: String,
    val os: String,
    val mode: String,
    val hash: String,
)
