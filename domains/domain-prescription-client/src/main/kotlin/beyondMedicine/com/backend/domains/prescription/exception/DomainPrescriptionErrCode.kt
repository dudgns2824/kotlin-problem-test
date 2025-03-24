package beyondMedicine.com.backend.domains.prescription.exception

import beyondMedicine.com.backend.commons.core.exception.IErrorCode

const val MODULE_NAME = "DMN-PRESCRPTION"

enum class DomainPrescriptionErrCode(
    override val byndMdcnErrorCode: Int,
    override val message: String?,
    override val httpStatusCode: Int = 500,
    override val errModuleName: String = MODULE_NAME,
) : IErrorCode {
    PRESCRIPTION_NOT_EXIST(9001, "해당 처방 코드가 존재하지 않습니다.", 404),
    ACTIVATE_CONDITION_NOT_SATISFIED(9002, "사용자의 기존 만료 되지 않은 처방코드가 이미 등록 되어 있습니다."),
    PRESCRIPTION_CODE_EXPIRED(9003, "해당 처방 코드가 만료 되었습니다."),
    PRESCRIPTION_CODE_NOT_REGISTER(9004, "해당 코드가 등록되지 않았습니다"),
}
