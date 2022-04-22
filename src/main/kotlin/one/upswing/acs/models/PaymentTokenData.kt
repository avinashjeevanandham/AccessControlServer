package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue
import com.fasterxml.jackson.annotation.JsonProperty

data class PaymentTokenData(
    val version: String,
    val token: String,
    val tokenAdditionalData: TokenAssuranceMethod,
    val tokenRequestorId: String,
    val tokenCryptogram: String,
    val tokenCryptogramValidityIndicator: TokenCryptogramValidityIndicator,
    val tokenStatusIndicator: String
)

enum class TokenCryptogramValidityIndicator(val indicator: String){
    @JsonProperty("01") VERIFIED("01"),
    @JsonProperty("02") FAILED("02"),
    @JsonProperty("03")
    @JsonEnumDefaultValue
    NOT_PERFORMED("03")
}

enum class TokenAssuranceMethod(val start: String, val end: String ) {
    NO_VALUE_SET("  ", "  "),
    ID_AND_V_NOT_PERFORMED("00", "00"),
    COMMON("01", "19"),
    TOKEN_PROGRAMME_SPECIFIC("20", "89")
}

enum class Direction  // constructor
    (  // internal state
    val angle: Int
) {
    // enum fields
    EAST(0), WEST(180), NORTH(90), SOUTH(270);

}