package beyondMedicine.com.backend.connector.annotation.docs.prescription

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter

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
            example = "JDQ4MTg4MSM1MSMkMSMkMCMkNzIkNTgxOTYxIzMxIyQxIyQ3IyQ4OSQyNjEwMDIjNTEjJDEjJDIjJDgz"
        ),
    ],
)
annotation class CreatePrescriptionCodeApiDocs()
