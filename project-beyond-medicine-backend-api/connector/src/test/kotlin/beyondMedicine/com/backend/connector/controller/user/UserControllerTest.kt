package beyondMedicine.com.backend.connector.controller.user

import beyondMedicine.com.backend.connector.BackendConnectorTest
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.TestInstance
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@BackendConnectorTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserControllerTest(
    private val mockMvc: MockMvc,
) : BehaviorSpec({

        given("사용자 검증 API 호출") {
            `when`("최신 버전으로 사용자 검증을 시도한다.") {
                mockMvc
                    .get(
                        "/api/beyondMedicine/user/verify?userId=e4e3ecbd-2208-4905-8120-426473d0eae9&version=0.1.2&os=android&mode=ReLeAsE&hash=Y95ULTuEF0uXNq7fSNa1EEzP0FU%3D",
                    ).andExpect {
                        status { isOk() }
                    }
                then("사용자 검증에 성공한다.") {
                    true shouldBe true
                }
            }
        }
    })
