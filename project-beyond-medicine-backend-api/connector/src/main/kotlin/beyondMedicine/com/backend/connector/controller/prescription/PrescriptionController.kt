package beyondMedicine.com.backend.connector.controller.prescription

import ApiResponse
import beyondMedicine.com.backend.connector.annotation.docs.prescription.CreatePrescriptionCodeApiDocs
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import beyondMedicine.com.backend.serviceBus.prescription.command.IBackendPrescriptionCommandServiceBus
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/api/beyondMedicine/prescription")
@RestController
@Tag(description = "처방 코드 관련 API 입니다.", name = "처방 코드 관련 API")
class PrescriptionController(
    private val backendPrescriptionCommandServiceBus: IBackendPrescriptionCommandServiceBus
) {
    // 처방 코드 생성 API
    @CreatePrescriptionCodeApiDocs
    @PostMapping("/code")
    fun createPrescriptionCode(
        @RequestParam(value = "hospitalId") hospitalId: String
    ) = ApiResponse.ok(backendPrescriptionCommandServiceBus.createPrescriptionCode(hospitalId))
}