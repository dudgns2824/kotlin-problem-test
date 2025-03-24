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
}
