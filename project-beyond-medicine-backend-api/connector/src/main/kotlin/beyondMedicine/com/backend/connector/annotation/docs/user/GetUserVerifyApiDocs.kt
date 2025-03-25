package beyondMedicine.com.backend.connector.annotation.docs.user

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Operation(
    summary = "사용자 - 사용자 검증 API",
    description =
        """
       요청 파라미터 존재
       파라미터는 전부 required 입니다.
       
       요청 파라미터
        ▷ userId: String / UUID로 생성된 사용자 아이디
        예: e4e3ecbd-2208-4905-8120-426473d0eae9
        
        ▷ version: String / Major.Minor.Patch 버전을 따르되, alpha 및 beta 버전 존재 / os와
        mode에 따라 상이
        예: 0.1.1 → 0.1.2-alpha.1 → 0.1.2-alpha.2 → 0.1.2-beta.1 → 0.1.2
        
        ▷ os: String / 대소문자와 관계없이 Android, iOS 중 하나
        예: android, Android, ios, iOS
        
        ▷ mode: String / 대소문자와 관계없이 debug, release 중 하나
        예: debug, DEBUG, release, RELEASE
        
        ▷ hash: String / os와 mode에 따라 상이
        예: android debug: Y95ULTuEF0uXNq7fSNa1EEzP0FU=
       
       1. 현재 version이 엔티티의 최신 버전보다 낮다면 사용자에게 업데이트를 권유하도록 응답
       2. 현재 version이 엔티티의 실행 가능한 최소 버전보다 낮다면 사용자에게 업데이트를 강제하도록 응답
       3. 현재 hash가 엔티티의 유효한 해시가 아니라면 에러 응답
       4. 사용자가 처방코드를 등록하지 않았거나, 만료되었을 때 에러가 응답
       5. 어떤 사용자가 어떤 version, os, mode, hash로 언제 요청했는지 테이블로 이력을 남겨야 해요.
       
       return 200 값
       "정상" -> 어떤 조건도 충족하지 않을 경우
       "어플의 업데이트가 필수입니다." -> 버전이 최신 버전 이하 최소 버전 이하
       "어플의 업데이트를 권장합니다." -> 버전이 최신 버전 이하 최소 버전 이상
    """,
    parameters = [
        Parameter(name = "userId", description = "사용자 ID UUID", required = true, example = "e4e3ecbd-2208-4905-8120-426473d0eae9"),
        Parameter(
            name = "version",
            description = "버전 정보",
            required = true,
            example = "0.1.1-alpha.1",
        ),
        Parameter(
            name = "os",
            description = "os 정보",
            required = true,
            example = "android",
        ),
        Parameter(
            name = "mode",
            description = "모드 정보",
            required = true,
            example = "ReLeAsE",
        ),
        Parameter(
            name = "hash",
            description = "해시 정보",
            required = true,
            example = "Y95ULTuEF0uXNq7fSNa1EEzP0FU=",
        ),
    ],
)
@ApiResponses(
    value = [
        ApiResponse(
            responseCode = "200",
            description = "사용자 - 사용자 검증 api 처방 코드 생성 성공",
            content = [
                Content(
                    mediaType = "application/json",
                    examples = [
                        ExampleObject(
                            value = """
{
  "code": 200,
  "message": "성공하였습니다.",
  "timestamp": "2025-03-25T16:03:53.234679900",
  "data": "어플의 업데이트가 필수입니다."
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
                  "byndMdcnErrorCode": "DMN-USER-8002",
                  "code": 500,
                  "message": "[DMN-USER-8002] 유효한 해시가 아닙니다.",
                  "timestamp": "2025-03-25T16:05:22.521055500",
                  "path": "/api/beyondMedicine/user/verify",
                  "method": "POST"
                }
                            """,
                        ),
                    ],
                ),
            ],
        ),
    ],
)
annotation class GetUserVerifyApiDocs
