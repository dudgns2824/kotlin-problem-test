package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.query

import beyondMedicine.com.backend.commons.core.exception.ByndMdcnException
import beyondMedicine.com.backend.domains.prescription.AnnotDomainPrescriptionClientTest
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.query.IPrescriptionCodeDomainQueryServiceBus
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

@AnnotDomainPrescriptionClientTest
class PrescriptionCodeDomainQueryServiceTest(
    private val prescriptionCodeDomainQueryServiceBus: IPrescriptionCodeDomainQueryServiceBus,
) : BehaviorSpec({
        given("처방 코드의 활성화 여부를 확인하고자 함") {
            `when`("처방 코드 L2H0U9P1로 prescriptionCodeIsActivate 메서드를 호출하면") {
                val prescriptionCode = "L2H0U9P1"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val result = prescriptionCodeDomainQueryServiceBus.prescriptionCodeIsActivate(prescriptionCode)

                then("true가 반환되어야 한다") {
                    result shouldBe true
                }
            }
            `when`("처방 코드 L2H0U9P2로 prescriptionCodeIsActivate 메서드를 호출하면") {
                val prescriptionCode = "L2H0U9P2"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val exception =
                    shouldThrow<ByndMdcnException> {
                        prescriptionCodeDomainQueryServiceBus.prescriptionCodeIsActivate(prescriptionCode)
                    }

                then("해당 custom domain exception이 반환되어야 한다") {
                    exception.message shouldBe "[DMN-PRESCRPTION-9001] 해당 처방 코드가 존재하지 않습니다."
                }
            }
        }
    })
