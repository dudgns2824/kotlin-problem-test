package beyondMedicine.com.backend.commons.core.exception

class ByndMdcnException(
    message: String? = null,
    override val httpStatusCode: Int,
    override val byndMdcnErrorCode: Int,
    override val errModuleName: String,
    val dataMap: Map<String, Any>?,
) : RuntimeException(message),
    IErrorCode
