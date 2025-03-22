package beyondMedicine.com.backend.domains.user.entity

import beyondMedicine.com.backend.domains.user.entity.id.VersionEntityId
import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

// 버전 검증용 테이블
@Entity
@Table(name = "version")
class VersionEntity {
    /**
     * 버전 정보 들어있는 id
     */
    @EmbeddedId
    @Column(name = "version")
    var id: VersionEntityId? = null
}
