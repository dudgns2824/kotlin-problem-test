package beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.query

import beyondMedicine.com.backend.domains.prescription.dto.response.PrescriptionCodeDetailResponseDto

interface IPrescriptionCodeDomainQueryRepositoryBus {
    // 처방 코드 활성화 여부
    fun prescriptionCodeIsActivate(prescriptionCode: String): Boolean

    // 처방 코드 상세 검색
    fun getDetailPrescriptionCode(id: String): PrescriptionCodeDetailResponseDto
}
