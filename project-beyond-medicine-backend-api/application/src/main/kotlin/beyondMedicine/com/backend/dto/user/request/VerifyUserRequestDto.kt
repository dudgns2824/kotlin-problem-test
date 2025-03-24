package beyondMedicine.com.backend.dto.user.request

data class VerifyUserRequestDto(
    val userId: String,
    val version: String,
    val os: String,
    val mode: String,
    val hash: String,
)
