package beyondMedicine.com.backend.modules.test.db

import beyondMedicine.com.backend.modules.test.db.config.ci.DatasourceConfig
import beyondMedicine.com.backend.modules.test.db.config.ci.QueryDslConfig
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(value = [DatasourceConfig::class, QueryDslConfig::class])
@ActiveProfiles("adapter-testfixture-local", "adapter-testfixture-env")
annotation class LocalDBTest
