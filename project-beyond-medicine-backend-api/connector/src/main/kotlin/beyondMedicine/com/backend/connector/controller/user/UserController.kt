package beyondMedicine.com.backend.connector.controller.user

import ApiResponse
import beyondMedicine.com.backend.connector.annotation.docs.user.GetUserVerifyApiDocs
import beyondMedicine.com.backend.dto.user.request.VerifyUserRequestDto
import beyondMedicine.com.backend.serviceBus.user.query.IBackendUserQueryServiceBus
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(description = "유저 관련 API 입니다.", name = "유저 관련 API")
@RequestMapping("/api/beyondMedicine/user")
class UserController(
    private val backendUserQueryServiceBus: IBackendUserQueryServiceBus,
) {
    // 사용자 검증 API
    @GetUserVerifyApiDocs
    @GetMapping("/verify")
    fun verify(
        @RequestParam(value = "userId") userId: String,
        @RequestParam(value = "version") version: String,
        @RequestParam(value = "os") os: String,
        @RequestParam(value = "mode") mode: String,
        @RequestParam(value = "hash") hash: String,
    ) = ApiResponse.ok(
        backendUserQueryServiceBus.verifyUser(
            VerifyUserRequestDto(
                userId = userId,
                version = version,
                os = os,
                mode = mode,
                hash = hash,
            ),
        ),
    )
}
