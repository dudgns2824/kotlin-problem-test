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
    summary = "처방 - 처방 코드 활성화 api",
    description =
        """
       요청 파라미터 존재
       파라미터는 전부 required 입니다.
       
       요청 파라미터
        ▷ userId: String / UUID로 생성된 사용자 아이디
        예: e4e3ecbd-2208-4905-8120-426473d0eae9
        ▷ accessCode: String / 처방코드 생성 API를 통해 만들어진 처방코드
        예: Y6U8Y8U8
    """,
    parameters = [
        Parameter(
            name = "userId",
            description = "UUID로 생성된 사용자 아이디",
            required = true,
            example = "e4e3ecbd-2208-4905-8120-426473d0eae9",
        ),
        Parameter(
            name = "accessCode",
            description = "처방코드 생성 API를 통해 만들어진 처방코드",
            required = true,
            example = "Y6U8Y8U8",
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
        ApiResponse(
            responseCode = "500",
            description =
                "처방 - 처방 코드 생성 api 생성 중 exception 이것은 예시이며, " +
                    "\n도메인에서 나는 에러들은 에러별로 서로 exception 코드가 상이 합니다. response code 500 공통",
            content = [
                Content(
                    mediaType = "application/json",
                    examples = [
                        ExampleObject(
                            value = """
                {
                  "byndMdcnErrorCode": "DMN-PRESCRPTION-9001",
                  "code": 404,
                  "message": "[DMN-PRESCRPTION-9001] 해당 처방 코드가 존재하지 않습니다.",
                  "timestamp": "2025-03-24T14:45:56.053954",
                  "path": "/api/beyondMedicine/prescription/code/activate",
                  "method": "PUT"
                }
                            """,
                        ),
                    ],
                ),
            ],
        ),
    ],
)
annotation class ActivatePrescriptionCodeApiDocs
