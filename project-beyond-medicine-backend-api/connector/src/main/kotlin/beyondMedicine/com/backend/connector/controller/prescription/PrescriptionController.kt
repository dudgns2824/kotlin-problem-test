package beyondMedicine.com.backend.connector.controller.prescription

import ApiResponse
import beyondMedicine.com.backend.connector.annotation.docs.prescription.ActivatePrescriptionCodeApiDocs
import beyondMedicine.com.backend.connector.annotation.docs.prescription.CreatePrescriptionCodeApiDocs
import beyondMedicine.com.backend.connector.annotation.validation.CheckUserIdExist
import beyondMedicine.com.backend.serviceBus.prescription.command.IBackendPrescriptionCommandServiceBus
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/beyondMedicine/prescription/code")
@RestController
@Validated
@Tag(description = "처방 코드 관련 API 입니다.", name = "처방 코드 관련 API")
class PrescriptionController(
    private val backendPrescriptionCommandServiceBus: IBackendPrescriptionCommandServiceBus,
) {
    // 처방 코드 생성 API
    @CreatePrescriptionCodeApiDocs
    @PostMapping
    fun createPrescriptionCode(
        @RequestParam(value = "hospitalId") hospitalId: String,
    ) = ApiResponse.ok(backendPrescriptionCommandServiceBus.createPrescriptionCode(hospitalId))

    // 처방 코드 활성화 API
    @ActivatePrescriptionCodeApiDocs
    @PutMapping("/activate")
    fun activatePrescriptionCode(
        @CheckUserIdExist @RequestParam(value = "userId") userId: String,
        @RequestParam(value = "accessCode") accessCode: String,
    ) = ApiResponse.ok(
        backendPrescriptionCommandServiceBus.activatePrescriptionCode(
            userId,
            accessCode,
        ),
    )
}
