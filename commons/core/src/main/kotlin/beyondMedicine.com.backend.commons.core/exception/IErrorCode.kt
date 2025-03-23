package beyondMedicine.com.backend.commons.core.exception

interface IErrorCode {
    val httpStatusCode: Int
    val message: String?
    val byndMdcnErrorCode: Int?
    val errModuleName: String?
}