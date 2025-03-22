@file:Suppress("ktlint:standard:filename")

package beyondMedicine.com.backend.commons.core.exception

fun byndMdcnException(errorCode: IErrorCode): ByndMdcnException = byndMdcnException(errorCode, null)

fun byndMdcnException(
    errorCode: IErrorCode,
    data: Map<String, Any>?,
): ByndMdcnException {
    val message =
        if (errorCode.message == null) {
            "[${errorCode.byndMdcnErrorCode}] 에러가 발생하였습니다."
        } else {
            "[${errorCode.errModuleName}-${errorCode.byndMdcnErrorCode}] ${errorCode.message}"
        }

    throw ByndMdcnException(
        message,
        errorCode.httpStatusCode,
        errorCode.byndMdcnErrorCode!!,
        errorCode.errModuleName!!,
        data,
    )
}
