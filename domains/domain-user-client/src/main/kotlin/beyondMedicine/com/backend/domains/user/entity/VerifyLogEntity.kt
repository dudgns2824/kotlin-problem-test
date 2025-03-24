package beyondMedicine.com.backend.domains.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

// 인증 로깅 테이블
@Entity
@Table(name = "verify_log")
class VerifyLogEntity {
    /**
     * id index
     */
    @Id
    @Column(name = "idx")
    var idx: Long? = null
}
