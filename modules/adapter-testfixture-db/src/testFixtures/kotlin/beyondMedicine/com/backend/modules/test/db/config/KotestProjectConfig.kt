package beyondMedicine.com.backend.modules.test.db.config

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.extensions.spring.SpringExtension
import org.springframework.stereotype.Component

/** kotest 전역 config
 * - springExtension 등록
 * */
@Component
class KotestProjectConfig : AbstractProjectConfig() {
    override val parallelism: Int = 16

    override fun extensions(): List<Extension> = listOf(SpringExtension)
}
