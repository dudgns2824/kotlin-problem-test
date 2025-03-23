package beyondMedicine.com.backend.domains.prescription.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

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

/*    *//**
     * 처방한 병원
     *//*
    @ManyToOne(fetch = FetchType.LAZY)
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