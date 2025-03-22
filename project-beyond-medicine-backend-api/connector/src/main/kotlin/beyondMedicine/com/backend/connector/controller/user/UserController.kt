package beyondMedicine.com.backend.connector.controller.user

import ApiResponse
import beyondMedicine.com.backend.connector.annotation.docs.user.GetUserVerifyApiDocs
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(description = "유저 조회 관련 API 입니다.", name = "유저 조회 관련 API")
@RequestMapping("/api/beyondMedicine/user")
class UserController {
    @GetUserVerifyApiDocs
    @GetMapping("/verify")
    fun verify(

    ) = ApiResponse.ok()
}