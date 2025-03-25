package beyondMedicine.com.backend.domains.prescription

import beyondMedicine.com.backend.modules.test.db.LocalDBTest
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DomainUserClientTestApplication::class])
@LocalDBTest
annotation class AnnotDomainUserClientTest
