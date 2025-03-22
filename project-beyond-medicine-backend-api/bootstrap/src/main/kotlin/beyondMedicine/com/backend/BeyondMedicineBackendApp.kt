package beyondMedicine.com.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan

@SpringBootApplication(
    scanBasePackages = [
        "beyondMedicine.com.backend",
        "beyondMedicine.com.backend.commons"
    ],
)
@EntityScan(basePackages = ["beyondMedicine.com.backend.domains"])
class BeyondMedicineBackendApp {
}