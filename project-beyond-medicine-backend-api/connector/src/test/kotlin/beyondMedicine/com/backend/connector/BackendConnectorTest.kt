package beyondMedicine.com.backend.connector

import beyondMedicine.com.backend.modules.test.db.LocalDBTest
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [BackendConnectorTestApplication::class])
@LocalDBTest
annotation class BackendConnectorTest
