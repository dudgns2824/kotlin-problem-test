package beyondMedicine.com.backend.connector

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan

@ComponentScan(
    value = ["beyondMedicine.com.backend"],
)
@EntityScan(
    basePackages = [
        "beyondMedicine.com.backend",
    ],
)
@SpringBootApplication(
    scanBasePackages = [
        "beyondMedicine.com.backend",
    ],
)
class BackendConnectorTestApplication {
}