package beyondMedicine.com.backend.domains.user.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

// 인증 로깅 테이블
@Entity
@Table(name = "verify_log")
class VerifyLogEntity {
    /**
     * index
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    var idx: Long? = null

    // 버전 정보
    @Column(name = "version", nullable = false)
    var version: String? = null

    // os 정보
    @Column(name = "os", nullable = false)
    var os: String? = null

    // mode 정보
    @Column(name = "mode", nullable = false)
    var mode: String? = null

    // hash 정보
    @Column(name = "hash", nullable = false)
    var hash: String? = null

    /**
     * 생성 일시
     * 어떤 처방코드를 언제 생성 했는지 이력 (굳이 처방 코드의 종류는 여기에 추가하면 되기 때문에 생성 일시만 필요한 현재
     * 로그성 테이블을 추가 할 필요가 없어 보임.)
     */
    @CreationTimestamp
    @Column(name = "request_at")
    var requestAt: LocalDateTime? = null
}
