package beyondMedicine.com.backend.domains.prescription.exception

import beyondMedicine.com.backend.commons.core.exception.IErrorCode

const val MODULE_NAME = "DMN-PRESCRPTION"

enum class DomainPrescriptionErrCode(
    override val byndMdcnErrorCode: Int,
    override val message: String?,
    override val httpStatusCode: Int = 500,
    override val errModuleName: String = MODULE_NAME,
): IErrorCode {
    PRESCRIPTION_NOT_EXIST(9001, "해당 처방 코드가 존재하지 않습니다.", 404),
}