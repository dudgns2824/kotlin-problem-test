package beyondMedicine.com.backend.domains.prescription.dto.response

import java.time.LocalDateTime

// 처방 코드 상세
data class PrescriptionCodeDetailResponseDto(
    val id: String, // 처방 코드 id
    val hospitalId: String, // 병원 id
    val isActivate: Boolean, // 활성화 여부
    val createdAt: LocalDateTime, // 생성 일시
    val updatedAt: LocalDateTime, // 수정 일시
    val deletedAt: LocalDateTime, // 삭제 일시
)
