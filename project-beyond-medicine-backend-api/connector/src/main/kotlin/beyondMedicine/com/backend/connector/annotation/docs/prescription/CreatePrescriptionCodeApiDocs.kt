package beyondMedicine.com.backend.connector.annotation.docs.prescription

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Operation(
    summary = "처방 - 처방 코드 생성 api",
    description =
        """
       요청 파라미터 존재
       파라미터는 전부 required 입니다.
       
       요청 파라미터
        ▷ hospitalId: String / 병원 아이디
        예: JDQ4MTg4MSM1MSMkMSMkMCMkNzIkNTgxOTYxIzMxIyQxIyQ3IyQ4OSQyNjEwMDIjNTEjJDEjJDIjJDgz
    """,
    parameters = [
        Parameter(
            name = "hospitalId",
            description = "병원 아이디",
            required = true,
            example = "JDQ4MTg4MSM1MSMkMSMkMCMkNzIkNTgxOTYxIzMxIyQxIyQ3IyQ4OSQyNjEwMDIjNTEjJDEjJDIjJDgz",
        ),
    ],
)
@ApiResponses(
    value = [
        ApiResponse(
            responseCode = "200",
            description = "처방 - 처방 코드 생성 api 처방 코드 생성 성공",
            content = [
                Content(
                    mediaType = "application/json",
                    examples = [
                        ExampleObject(
                            value = """
{
  "code": 200,
  "message": "성공하였습니다.",
  "timestamp": "2025-03-24T10:47:21.684050",
  "data": "G9A0G3M2"
}
                            """,
                        ),
                    ],
                ),
            ],
        ),
    ],
)
annotation class CreatePrescriptionCodeApiDocs
