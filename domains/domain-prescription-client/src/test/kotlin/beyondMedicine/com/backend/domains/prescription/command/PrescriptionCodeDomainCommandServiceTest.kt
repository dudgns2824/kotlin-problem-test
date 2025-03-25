package beyondMedicine.com.backend.domains.prescription.command

import beyondMedicine.com.backend.commons.core.exception.ByndMdcnException
import beyondMedicine.com.backend.domains.prescription.AnnotDomainPrescriptionClientTest
import beyondMedicine.com.backend.domains.prescription.repository.prescriptionCode.command.PrescriptionCodeDomainCommandRepository
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.command.IPrescriptionCodeDomainCommandServiceBus
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.TestInstance
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager

// prescriptionCodeDomainCommandServiceBus 테스트 코드
@AnnotDomainPrescriptionClientTest
@TestExecutionListeners(TransactionalTestExecutionListener::class)
@Transactional // 테스트 코드에서만 부모 트랜잭션 전파가 안되는 에러.... TransactionRequiredException
// behaviorSpec << 여기서 부모 트랜잭션 전파가 안됐네요 이유는 잘 모르겠습니다
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrescriptionCodeDomainCommandServiceTest(
    private val prescriptionCodeDomainCommandServiceBus: IPrescriptionCodeDomainCommandServiceBus,
    private val prescriptionCodeDomainCommandRepository: PrescriptionCodeDomainCommandRepository,
) : FunSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
        test("트랜잭션 테스트") {
            val isActive = TransactionSynchronizationManager.isActualTransactionActive()
            println("현재 트랜잭션 활성 상태: $isActive")
            isActive shouldBe true
        }
        test("처방코드를 생성 하려고 함") {
            val hospitalId = "JDQ4MTg4MSM1MSMkMSMkMCMkNzIkNTgxOTYxIzMxIyQxIyQ3IyQ4OSQyNjEwMDIjNTEjJDEjJDIjJDgz"

            // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 까지 생략 transaction 문제
            // repository 추상체 호출 -> repository 구현체 호출
            val result = prescriptionCodeDomainCommandServiceBus.createPrescriptionCode(hospitalId)

            result.shouldBeInstanceOf<String>()
        }
        test("정상적인 활성화 시도") {
            val prescriptionCode = "T6V5X1P0"
            val userId = "g4e2ecga-1305-6225-5121-a2h471d0na2a"

            // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
            val result = prescriptionCodeDomainCommandServiceBus.activatePrescriptionCode(userId, prescriptionCode)

            result shouldBe true
        }
        test("틀린 처방코드로 활성화 시도") {
            val prescriptionCode = "T1I3Y6K2"
            val userId = "g4e2ecga-1305-6225-5121-a2h471d0na2a"

            // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
            val exception =
                shouldThrow<ByndMdcnException> {
                    prescriptionCodeDomainCommandServiceBus.activatePrescriptionCode(userId, prescriptionCode)
                }
            exception.message shouldBe "[DMN-PRESCRPTION-9001] 해당 처방 코드가 존재하지 않습니다."
        }
        test("기존 처방코드가 만료되지 않은 사용자의 활성화 시도") {
            val prescriptionCode = "T6V5X1P0"
            val userId = "d4e3ebba-2218-4906-2170-n2447rd0ehe9"

            // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
            val exception =
                shouldThrow<ByndMdcnException> {
                    prescriptionCodeDomainCommandServiceBus.activatePrescriptionCode(userId, prescriptionCode)
                }
            exception.message shouldBe "[DMN-PRESCRPTION-9002] 사용자의 기존 만료 되지 않은 처방코드가 이미 등록 되어 있습니다."
        }
    }
}
