package one.upswing.acs.validators

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.io.IOException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


//@JacksonAnnotationsInside
//@Retention(AnnotationRetention.RUNTIME)
//@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyyMMdd")
//annotation class YYYYMMDD(
//    val message: String = "{invalid.uuid}",
//    val groups: Array<KClass<*>> = [],
//    val payload: Array<KClass<out Payload>> = []
//)

//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
//@Retention(AnnotationRetention.RUNTIME)
//@Constraint(validatedBy = [DateFormatValidator::class])
//@MustBeDocumented
//annotation class DateFormat(
//    val message: String = "Value is reserved and must not be used",
//    val groups: Array<KClass<*>> = [],
//    val payload: Array<KClass<out Payload>> = []
//)
//
//class DateFormatValidator : ConstraintValidator<DateFormat, String> {
//
//    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
//        if (value == null) return true
//        try {
//            val format = SimpleDateFormat("yyyyMMdd")
//            format.isLenient = false
//            val a = format.parse(value)
//            println(a)
//            return true
//        } catch (e: ParseException) {
//            //throw an error
//            return false
//        }
//    }
//}

abstract class DateSerializer : JsonDeserializer<Date?>() {

    @Throws(IOException::class, JsonProcessingException::class)
    override fun deserialize(jsonParser: JsonParser, deserializationContext: DeserializationContext?): Date {
        val format = SimpleDateFormat(format())
        format.isLenient = false
        val date: String = jsonParser.text
        return try {
            format.parse(date)
        } catch (e: ParseException) {
            throw RuntimeException(e)
        }
    }

    abstract fun format(): String;
}

class YYYYMMDD: DateSerializer() {
    override fun format(): String  = "yyyyMMdd"
}

class YYYYMMDDHHMM: DateSerializer() {
    override fun format(): String  = "yyyyMMddhhmm"
}

class YYMM: DateSerializer() {
    override fun format(): String = "yyMM"
}