package one.upswing.acs.validators

import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [CheckReservedValidator::class])
@MustBeDocumented
annotation class CheckReserved(
    val message: String = "Value is reserved and must not be used",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class CheckReservedValidator : ConstraintValidator<CheckReserved, String> {

    private var enum: Enum<*>? = null

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) return true
        println(enum)
        return true
    }
}