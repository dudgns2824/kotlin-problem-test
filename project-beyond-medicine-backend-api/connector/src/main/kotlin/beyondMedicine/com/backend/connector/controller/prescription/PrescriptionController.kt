package beyondMedicine.com.backend.connector.controller.prescription

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(description = "처방 관련 API 입니다.", name = "처방 조회 관련 API")
@RequestMapping("/api/beyondMedicine/prescription")
class PrescriptionController {
}