package beyondMedicine.com.backend.domains.user.entity.id

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotNull
import java.io.Serializable

@Embeddable
class VersionEntityId : Serializable {
    // 최신 버전 정보
    @NotNull
    @Column(name = "recent_version", nullable = false)
    var recentVersion: String? = null

    // 최소 버전 정보
    @NotNull
    @Column(name = "min_version", nullable = false)
    var minVersion: String? = null

    // os 정보
    @NotNull
    @Column(name = "os", nullable = false)
    var os: String? = null

    // mode 정보
    @NotNull
    @Column(name = "mode", nullable = false)
    var mode: String? = null

    // hash 정보
    @NotNull
    @Column(name = "hash", nullable = false)
    var hash: String? = null
}
