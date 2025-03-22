package beyondMedicine.com.backend.domains.prescription.query

import beyondMedicine.com.backend.commons.core.exception.ByndMdcnException
import beyondMedicine.com.backend.domains.prescription.AnnotDomainUserClientTest
import beyondMedicine.com.backend.domains.user.dto.user.request.UserVerifyRequestDto
import beyondMedicine.com.backend.domains.user.servicebus.user.query.IUserDomainQueryServiceBus
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

// prescriptionCodeDomainQueryService 테스트 코드
@AnnotDomainUserClientTest
class UserDomainQueryServiceTest(
    private val userDomainQueryServiceBus: IUserDomainQueryServiceBus,
) : BehaviorSpec({
        given("유저의 상세 정보를 가져오고자 함.") {
            `when`("유저 abe2ehgd-3251-1272-3722-b1hh726ahd6n의 정보를 가져옴") {
                val userId = "abe2ehgd-3251-1272-3722-b1hh726ahd6n"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val result = userDomainQueryServiceBus.getUserDetail(userId)

                then("에러 없이 id가 abe2ehgd-3251-1272-3722-b1hh726ahd6n인 유저 상세 정보 return ") {
                    result.userId shouldBe "abe2ehgd-3251-1272-3722-b1hh726ahd6n"
                }
            }
            `when`("존재 하지 않는 bbe2ehgd-3251-1272-3722-b1hh726ahd6n의 정보를 가져옴") {
                val userId = "bbe2ehgd-3251-1272-3722-b1hh726ahd6n"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val exception =
                    shouldThrow<ByndMdcnException> {
                        userDomainQueryServiceBus.getUserDetail(userId)
                    }

                then("해당 custom domain exception이 반환되어야 한다") {
                    exception.message shouldBe "[DMN-USER-8001] 해당 유저가 존재하지 않습니다."
                }
            }
        }
        given("유저 id가 존재하는지 알아오고자 함") {
            `when`("유저 abe2ehgd-3251-1272-3722-b1hh726ahd6n의 정보를 가져옴") {
                val userId = "abe2ehgd-3251-1272-3722-b1hh726ahd6n"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val result = userDomainQueryServiceBus.isUserIdExist(userId)

                then("에러 없이 id가 abe2ehgd-3251-1272-3722-b1hh726ahd6n인 유저 상세 정보 return ") {
                    result shouldBe true
                }
            }
            `when`("존재 하지 않는 bbe2ehgd-3251-1272-3722-b1hh726ahd6n의 정보를 가져옴") {
                val userId = "bbe2ehgd-3251-1272-3722-b1hh726ahd6n"

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val result = userDomainQueryServiceBus.isUserIdExist(userId)

                then("해당 custom domain exception이 반환되어야 한다") {
                    result shouldBe false
                }
            }
        }
        given("사용자 검증을 하고자 함") {
            `when`("유저 abe2ehgd-3251-1272-3722-b1hh726ahd6n의 정보를 검증") {
                val userDto =
                    UserVerifyRequestDto(
                        userId = "abe2ehgd-3251-1272-3722-b1hh726ahd6n",
                        version = "0.1.2-alpha.1",
                        os = "android",
                        mode = "reLeasE",
                        hash = "Y95ULTuEF0uXNq7fSNa1EEzP0FU=",
                    )

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val result = userDomainQueryServiceBus.verifyUser(userDto)

                then("에러 없이 버전 로직에 따라 어플의 업데이트를 권장합니다. return") {
                    result shouldBe "어플의 업데이트를 권장합니다."
                }
            }
            `when`("유저 abe2ehgd-3251-1272-3722-b1hh726ahd6n의 정보를 검증") {
                val userDto =
                    UserVerifyRequestDto(
                        userId = "abe2ehgd-3251-1272-3722-b1hh726ahd6n",
                        version = "0.0.1-alpha.1",
                        os = "android",
                        mode = "reLeasE",
                        hash = "Y95ULTuEF0uXNq7fSNa1EEzP0FU=",
                    )

                // 서비스 추상체 메서드 호출 -> 서비스 구현체 호출 -> repository 추상체 호출 -> repository 구현체 호출
                val result = userDomainQueryServiceBus.verifyUser(userDto)

                then("에러 없이 버전 로직에 따라 어플의 업데이트가 필수입니다. return") {
                    result shouldBe "어플의 업데이트가 필수입니다."
                }
            }
        }
    })
