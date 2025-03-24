package beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.query

import beyondMedicine.com.backend.domains.prescription.dto.response.PrescriptionCodeDetailResponseDto

interface IPrescriptionCodeDomainQueryServiceBus {
    // 처방 코드 활성화 여부
    fun prescriptionCodeIsActivate(prescriptionCode: String): Boolean

    // 처방 코드 id 기준 조회
    fun getPrescriptionCodeDetail(id: String): PrescriptionCodeDetailResponseDto
}
