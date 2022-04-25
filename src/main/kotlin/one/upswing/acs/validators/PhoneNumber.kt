package one.upswing.acs.validators

import one.upswing.acs.models.Phone
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PhoneValidator::class])
@MustBeDocumented
annotation class PhoneNumber(
    val message: String = "Not a valid phone number",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class PhoneValidator : ConstraintValidator<PhoneNumber, Phone> {
    // https://stackoverflow.com/questions/6478875/regular-expression-matching-e-164-formatted-phone-numbers
    private val phoneRegex = "^\\+?[1-9]\\d{1,14}\$"

    override fun isValid(value: Phone?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) return true
        return try {
            val (cc, subscriber) = value
            Regex(phoneRegex).containsMatchIn( cc + subscriber)

        } catch (e: Exception) {
            //throw an error
            false
        }
    }

}