package beyondMedicine.com.backend.domains.prescription.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Suppress("ktlint:standard:no-consecutive-comments")
// 처방 코드 테이블
@Entity
@Table(name = "prescription_code")
class PrescriptionCodeDomainEntity {
    /**
     * 처방 코드 = id
     */
    @Id
    @Column(name = "id")
    var id: String? = null

    /**
     * 처방한 병원
     */
    /*@ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "hospital_id", nullable = false)
        var hospital: HospitalDomainEntity? = null*/

    /**
     * 처방한 병원 id
     */
    @Column(name = "hospital_id")
    var hospitalId: String? = null

    /**
     * 활성화 여부
     */
    @Column(name = "is_activate")
    var isActivate: Boolean? = false

    /**
     * 생성 일시
     * 어떤 처방코드를 언제 생성 했는지 이력 (굳이 처방 코드의 종류는 여기에 추가하면 되기 때문에 생성 일시만 필요한 현재
     * 로그성 테이블을 추가 할 필요가 없어 보임.)
     */
    @CreationTimestamp
    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null

    /**
     * 만료 일시
     */
    @Column(name = "expired_at")
    var expiredAt: LocalDateTime? = null

    /**
     * 수정 일시
     */
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null

    /**
     * 삭제 일시
     */
    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null
}
