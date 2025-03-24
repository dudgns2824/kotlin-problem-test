package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.query

import beyondMedicine.com.backend.domains.prescription.AnnotDomainPrescriptionClientTest
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.query.IPrescriptionCodeDomainQueryServiceBus
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

@AnnotDomainPrescriptionClientTest
class PrescriptionCodeDomainQueryServiceTest(
    private val prescriptionCodeDomainQueryServiceBus: IPrescriptionCodeDomainQueryServiceBus
) : BehaviorSpec({
    given("처방 코드 L2H0U9P1에 대해 활성화 여부를 확인하고자 함") {
        `when`("prescriptionCodeIsActivate 메서드를 호출하면") {
            val prescriptionCode = "L2H0U9P1"

            // 서비스 메서드 호출
            val result = prescriptionCodeDomainQueryServiceBus.prescriptionCodeIsActivate(prescriptionCode)

            then("true가 반환되어야 한다") {
                result shouldBe true
            }
        }
    }
})