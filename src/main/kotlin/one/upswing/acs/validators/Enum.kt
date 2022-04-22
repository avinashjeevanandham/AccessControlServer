package one.upswing.acs.validators

import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [EnumValidatorImpl::class])
annotation class EnumValidator(
    val message: String = "Enum is not valid",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
)

class EnumValidatorImpl : ConstraintValidator<EnumValidator, String> {

    var values: Set<String> = mutableSetOf()
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) return true
        return value.isNotBlank()
    }

//    override fun initialize(constraintAnnotation: EnumValidator?) {
//        val enumClass: KClass<out Enum<*>> = constraintAnnotation.enumClass
//        enumClass.
//    }
}

