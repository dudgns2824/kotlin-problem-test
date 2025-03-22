package beyondMedicine.com.backend.connector.annotation.validation

import beyondMedicine.com.backend.domains.user.servicebus.user.query.IUserDomainQueryServiceBus
import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import org.springframework.stereotype.Component
import kotlin.reflect.KClass

@Constraint(validatedBy = [CheckUserIdExistValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.TYPE,
    AnnotationTarget.FIELD,
    AnnotationTarget.VALUE_PARAMETER,
)
annotation class CheckUserIdExist(
    val message: String = "유저 ID가 존재하지 않습니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
)

@Component
class CheckUserIdExistValidator(
    private val userDomainQueryServiceBus: IUserDomainQueryServiceBus
) : ConstraintValidator<CheckUserIdExist, String> {
    override fun isValid(
        value: String?,
        context: ConstraintValidatorContext?,
    ): Boolean {
        return value?.let {
            userDomainQueryServiceBus.isUserIdExist(value)
        } ?: false
    }
}
