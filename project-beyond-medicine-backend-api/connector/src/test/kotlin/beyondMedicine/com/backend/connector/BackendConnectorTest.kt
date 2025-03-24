package beyondMedicine.com.backend.connector

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@ActiveProfiles(
    "adapter-data-jpa-local",
    "adapter-data-jpa-env",
)
@SpringBootTest(
    classes = [
        BackendConnectorTestApplication::class
    ],
    properties = [
        "spring.config.location=classpath:application.yml",
    ]
)
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@EnableAutoConfiguration
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@AutoConfigureMockMvc
annotation class BackendConnectorTest
