package beyondMedicine.com.backend.domains.user.exception

import beyondMedicine.com.backend.commons.core.exception.IErrorCode

const val MODULE_NAME = "DMN-USER"

enum class DomainUserErrCode(
    override val byndMdcnErrorCode: Int,
    override val message: String?,
    override val httpStatusCode: Int = 500,
    override val errModuleName: String = MODULE_NAME,
) : IErrorCode {
    USER_NOT_EXIST(8001, "해당 유저가 존재하지 않습니다.", 404),
    HASH_NOT_VALID(8002, "유효한 해시가 아닙니다."),
    PRESCRIPTION_CODE_NOT_REGIST(8003, "해당 유저의 처방코드가 등록 되지 않았습니다."),
    VERSION_NOT_VALID(8004, "유효한 버전이 아닙니다."),
}
