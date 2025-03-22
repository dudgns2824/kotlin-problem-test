package beyondMedicine.com.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "beyondMedicine.com.backend",
    ],
)
@EntityScan(basePackages = ["beyondMedicine.com.backend.domains"])
class BeyondMedicineBackendApp

fun main(args: Array<String>) {
    runApplication<BeyondMedicineBackendApp>(*args)
}