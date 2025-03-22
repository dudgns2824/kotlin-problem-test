package beyondMedicine.com.backend.domains.user.dto.verifyLog.request

data class CreateVerifyLogRequestDto(
    val version: String,
    val os: String,
    val mode: String,
    val hash: String
)