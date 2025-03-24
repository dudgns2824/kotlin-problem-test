package beyondMedicine.com.backend.domains.user.dto.response

import java.time.LocalDateTime

// 유저 상세 response dto
data class UserDetailResponseDto(
    val userId: String, // 유저 아이디
    val prescriptionCode: String, // 처방 코드
    val createdAt: LocalDateTime, // 생성 일시
    val updatedAt: LocalDateTime?, // 수정 일시
    val deletedAt: LocalDateTime?, // 삭제 일시
)
