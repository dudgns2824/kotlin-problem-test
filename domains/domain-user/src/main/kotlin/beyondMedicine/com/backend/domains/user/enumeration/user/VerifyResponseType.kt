package beyondMedicine.com.backend.domains.user.enumeration.user

enum class VerifyResponseType(
    val description: String,
) {
    UPDATE_RECOMMEND("어플의 업데이트를 권장합니다."),
    UPDATE_FORCE("어플의 업데이트가 필수입니다."),
}
