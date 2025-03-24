package beyondMedicine.com.backend.domains.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

// 유저 테이블
@Entity
@Table(name = "beyond_medicine_user") // user로 하려 했는데 제 디비에 이미 쓰고 있어서 ㅎㅎ..
class UserEntity {
    /**
     * 유저 아이디 (binary로 생성하여 uuid대응 하려 했으나, -제거 변환 util을 일일히 거치는 것과
     * 클라이언트 에서 보내는 uuid string을 변하지 않게 유지하는게 좋을것 같아 string으로 결정
     */
    @Id
    @Column(name = "user_id")
    var userId: String? = null

    /**
     * 생성 일시
     */
    @CreationTimestamp
    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null

    /**
     * 수정 일시
     */
    @UpdateTimestamp
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null

    /**
     * 삭제 일시
     */
    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null
}
