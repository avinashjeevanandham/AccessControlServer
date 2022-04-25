package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import one.upswing.acs.InvalidDataFormatException
import one.upswing.acs.ReservedRangeException
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class PaymentTokenData(
    @Pattern(regexp = "^1\\.0\$")
    val version: String,
    @Size(min = 13, max = 14)
    val token: String?,
    @Size(max = 500)
    val tokenAdditionalData: JsonNode?,
    @Pattern(regexp = "^\\d{11}\$")
    val tokenRequestorId: String?,
    @Size(max = 4000)
    val tokenCryptogram: String?,
    val tokenCryptogramValidityIndicator: TokenCryptogramValidityIndicator? = TokenCryptogramValidityIndicator.NOT_PERFORMED,
    @Size(max = 40)
    val tokenStatusIndicator: String?,
    @Size(max = 40)
    val tokenAssuranceMethod:TokenAssuranceMethod?
)

enum class TokenCryptogramValidityIndicator(val indicator: String){
    @JsonProperty("01") VERIFIED("01"),
    @JsonProperty("02") FAILED("02"),
    @JsonProperty("03") NOT_PERFORMED("03");

    companion object{

        private val errorDetail: String = "Value should be one of ${TokenCryptogramValidityIndicator.values().map { it -> it.indicator }.toString()}"
        private val enumMap: HashMap<String, TokenCryptogramValidityIndicator> = HashMap<String, TokenCryptogramValidityIndicator>();

        init {
            for (item in TokenCryptogramValidityIndicator.values()) {
                enumMap[item.indicator] = item
            }
        }
        @JsonCreator
        @JvmStatic
        fun from(value: String): TokenCryptogramValidityIndicator? {
            val indicatorValue: Int =
                value.toIntOrNull() ?: throw InvalidDataFormatException("Invalid value", errorDetail)
            if (indicatorValue in 4..79) throw ReservedRangeException("Reserved for EMVCo future use", errorDetail)
            if (indicatorValue in 80..99) throw ReservedRangeException("Reserved for DS use", errorDetail)
            if (indicatorValue > 99) throw InvalidDataFormatException("Invalid value", errorDetail)
            return enumMap[value]
        }
    }
}

enum class TokenAssuranceMethod() {
    NO_VALUE_SET,
    ID_AND_V_NOT_PERFORMED,
    COMMON,
    TOKEN_PROGRAMME_SPECIFIC;

    companion object{
        @JsonCreator
        @JvmStatic
        fun from(value: String): TokenAssuranceMethod? {
            val errorDetail: String = "Must be empty or between 01 - 89"
            if (value == "  ") return  TokenAssuranceMethod.NO_VALUE_SET
            val indicatorValue: Int =
                value.toIntOrNull() ?: throw InvalidDataFormatException("Invalid value", errorDetail)
            if (indicatorValue == 0) return TokenAssuranceMethod.ID_AND_V_NOT_PERFORMED
            if (indicatorValue in 1..19) return TokenAssuranceMethod.COMMON
            if (indicatorValue in 20..89) return TokenAssuranceMethod.TOKEN_PROGRAMME_SPECIFIC
            if (indicatorValue in 90..99) throw ReservedRangeException("Reserved for future EMVCo use", errorDetail)
            if (indicatorValue > 99) throw InvalidDataFormatException("Invalid value", errorDetail)
            return null
        }
    }
}
