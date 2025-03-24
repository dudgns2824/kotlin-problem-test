package beyondMedicine.com.backend.domains.prescription

import beyondMedicine.com.backend.modules.test.db.config.ci.DatasourceConfig
import beyondMedicine.com.backend.modules.test.db.config.ci.QueryDslConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.context.annotation.Import

@Import(value = [QueryDslConfig::class])
@ComponentScan(
    value = ["beyondMedicine.com.backend.domains", "beyondMedicine.com.backend.modules"],
    excludeFilters = [
        ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE,
            classes = [DatasourceConfig::class, QueryDslConfig::class],
        ),
    ],
)
@EntityScan(basePackages = ["beyondMedicine.com.backend.domains"])
@SpringBootApplication(
    scanBasePackages = ["beyondMedicine.com.backend.domains", "beyondMedicine.com.backend.modules"],
    exclude = [DataSourceAutoConfiguration::class],
)
class DomainPrescriptionClientTestApplication