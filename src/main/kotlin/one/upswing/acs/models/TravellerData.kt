package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue
import com.fasterxml.jackson.annotation.JsonProperty

data class TravellerData(
    val airlineLoyaltyStatus: LoyaltyStatus,
    val carRentalLoyaltyStatus: LoyaltyStatus,
    val hotelLoyaltyStatus: LoyaltyStatus,
    val airlinePassengerIndicator: Indicator,
    val carRentalDriverIndicator: Indicator,
    val hotelGuestIndicator: Indicator,
    val name: String,
    val type: TravellerType
)

enum class TravellerType(val type: String){
    @JsonProperty("ADT") ADULT("ADT"),
    @JsonProperty("CHD") CHILD("CHD"),
    @JsonProperty("INF") INFANT("INF")
}
enum class LoyaltyStatus(val status: String){
    @JsonProperty("01") NONE("01"),
    @JsonProperty("02") ENROLLED("02"),
    @JsonProperty("03") STATUS("03")
}

enum class Indicator(val indicator: String){
    @JsonProperty("Y") YES("Y"),
    @JsonProperty("N")
    @JsonEnumDefaultValue
    NO("N")
}