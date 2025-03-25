package beyondMedicine.com.backend.domains.prescription.service.prescriptionCode.query

import beyondMedicine.com.backend.commons.core.exception.ByndMdcnException
import beyondMedicine.com.backend.domains.prescription.AnnotDomainPrescriptionClientTest
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.query.IPrescriptionCodeDomainQueryServiceBus
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

// prescriptionCodeDomainQueryService 테스트 코드
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
        given("처방 코드 상세 정보를 가져오고자 함") {
            `when`("처방 코드 L2H0U9P1의 정보를 가져오려고 한다.") {
                val prescriptionCode = "L2H0U9P1"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val result = prescriptionCodeDomainQueryServiceBus.getPrescriptionCodeDetail(prescriptionCode)

                then("L2H0U9P1이 id인 dto가 반환되어야 한다") {
                    result.id shouldBe "L2H0U9P1"
                }
            }
            `when`("처방 코드 L2H5U9P2로 prescriptionCodeIsActivate 메서드를 호출하면") {
                val prescriptionCode = "L2H5U9P2"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val exception =
                    shouldThrow<ByndMdcnException> {
                        prescriptionCodeDomainQueryServiceBus.getPrescriptionCodeDetail(prescriptionCode)
                    }

                then("해당 custom domain exception이 반환되어야 한다") {
                    exception.message shouldBe "[DMN-PRESCRPTION-9001] 해당 처방 코드가 존재하지 않습니다."
                }
            }
        }
        given("처방코드 등록 및 만료 체크를 하려고 함") {
            `when`("처방 코드 L2H0U9P1의 등록 및 만료 체크를 하려고 함") {
                val prescriptionCode = "L2H0U9P1"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val result = prescriptionCodeDomainQueryServiceBus.verifyUserPrescriptionCodeCheck(prescriptionCode)

                then("true가 반환 되어야 한다.") {
                    result shouldBe true
                }
            }
            `when`("처방 코드 S9P6P7U8의 등록 및 만료 체크를 하려고 함") {
                val prescriptionCode = "S9P6P7U8"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val exception =
                    shouldThrow<ByndMdcnException> {
                        prescriptionCodeDomainQueryServiceBus.verifyUserPrescriptionCodeCheck(prescriptionCode)
                    }

                then("해당 custom domain exception이 반환되어야 한다") {
                    exception.message shouldBe "[DMN-PRESCRPTION-9003] 해당 처방 코드가 만료 되었습니다."
                }
            }
            `when`("처방 코드 T1I3Y6K1의 등록 및 만료 체크를 하려고 함") {
                val prescriptionCode = "T1I3Y6K1"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val exception =
                    shouldThrow<ByndMdcnException> {
                        prescriptionCodeDomainQueryServiceBus.verifyUserPrescriptionCodeCheck(prescriptionCode)
                    }

                then("해당 custom domain exception이 반환되어야 한다") {
                    exception.message shouldBe "[DMN-PRESCRPTION-9004] 해당 코드가 등록되지 않았습니다."
                }
            }
        }
    })
