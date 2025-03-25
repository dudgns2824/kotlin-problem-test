package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.command

import beyondMedicine.com.backend.commons.core.exception.ByndMdcnException
import beyondMedicine.com.backend.domains.prescription.AnnotDomainPrescriptionClientTest
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.command.IPrescriptionCodeDomainCommandServiceBus
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.transaction.annotation.Transactional

// prescriptionCodeDomainCommandService 테스트 코드
@AnnotDomainPrescriptionClientTest
@Transactional
@TestExecutionListeners(
    TransactionalTestExecutionListener::class,
    DependencyInjectionTestExecutionListener::class,
)
class PrescriptionCodeDomainCommandServiceTest(
    private val prescriptionCodeDomainCommandServiceBus: IPrescriptionCodeDomainCommandServiceBus,
) : BehaviorSpec({

        isolationMode = IsolationMode.InstancePerLeaf

        given("처방코드를 생성 하려고 함") {
            `when`("처방코드를 생성 한다.") {
                val hospitalId = "JDQ4MTg4MSM1MSMkMSMkMCMkNzIkNTgxOTYxIzMxIyQxIyQ3IyQ4OSQyNjEwMDIjNTEjJDEjJDIjJDgz"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val result = prescriptionCodeDomainCommandServiceBus.createPrescriptionCode(hospitalId)

                then("string형 데이터가 반환되어야 한다") {
                    result.shouldBeInstanceOf<String>()
                }
            }
        }
        given("처방코드를 활성화 하려고 함") {
            `when`("정상적인 활성화 시도") {
                val prescriptionCode = "D7A1M3D1"
                val userId = "g4e2ecga-1305-6225-5121-a2h471d0na2a"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val result = prescriptionCodeDomainCommandServiceBus.activatePrescriptionCode(userId, prescriptionCode)

                then("성공적으로 활성화가 되었으면 true가 반환 되어야 한다.") {
                    result shouldBe true
                }
            }

            `when`("틀린 처방코드로 활성화 시도") {
                val prescriptionCode = "T1I3Y6K2"
                val userId = "g4e2ecga-1305-6225-5121-a2h471d0na2a"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val exception =
                    shouldThrow<ByndMdcnException> {
                        prescriptionCodeDomainCommandServiceBus.activatePrescriptionCode(userId, prescriptionCode)
                    }
                then("해당 custom domain exception이 반환되어야 한다") {
                    exception.message shouldBe "[DMN-PRESCRPTION-9001] 해당 처방 코드가 존재하지 않습니다."
                }
            }

            `when`("기존 처방코드가 만료되지 않은 사용자의 활성화 시도") {
                val prescriptionCode = "D7A1M3D1"
                val userId = "d4e3ebba-2218-4906-2170-n2447rd0ehe9"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val exception =
                    shouldThrow<ByndMdcnException> {
                        prescriptionCodeDomainCommandServiceBus.activatePrescriptionCode(userId, prescriptionCode)
                    }

                then("해당 custom domain exception이 반환되어야 한다") {
                    exception.message shouldBe "[DMN-PRESCRPTION-9002] 사용자의 기존 만료 되지 않은 처방코드가 이미 등록 되어 있습니다."
                }
            }
        }
    })
