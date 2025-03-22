package beyondMedicine.com.backend.connector.annotation.docs.user

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.ExampleObject

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
    """,
    parameters = [
        Parameter(name = "userId", description = "사용자 ID UUID", required = true),
        Parameter(
            name = "version",
            description = "버전 정보",
            required = true,
            example = "0.1.2-alpha.1"
        ),
        Parameter(
            name = "os",
            description = "os 정보",
            required = true,
            example = "android"
        ),
        Parameter(
            name = "mode",
            description = "모드 정보",
            required = true,
            example = "ReLeAsE"
        ),
        Parameter(
            name = "hash",
            description = "해시 정보",
            required = true,
            example = "ReLeAsE"
        )
    ],
)
annotation class GetUserVerifyApiDocs
