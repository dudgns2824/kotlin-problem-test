package beyondMedicine.com.backend.domains.user.entity

import jakarta.persistence.*
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
     * 처방 코드
     * OneToOne 연관관계 매핑을 고려 해 볼 수 있으나, 그렇게 하면 도메인 주도 개발의 의미가 퇴색 된다고 생각함.
     * 차라리 도메인 주도 개발에선 prescriptionQueryServiceBus에 id기준으로 처방 코드 dto를 가져오는것이 맞다고 생각합니다.
     */
    @Column(name = "prescription_code")
    var prescriptionCode: String? = null

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
