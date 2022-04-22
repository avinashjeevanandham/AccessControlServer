package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class HotelData(
    val propertyInfo: PropertyInformation,
    val reservationInfo: HotelReservationInformation
)

data class PropertyInformation(
    val name: String,
    val chainCode: String,
    val propertyCode: String,
    val referenceCode: String,
    val addrLine1: String,
    val addrLine2: String,
    val addrLine3: String,
    val addrCity: String,
    val addrState: String, //todo 3166-2
    val addrPostCode: String,
    val addrCountry: String,
    val email: String, // RFC 5322
    val phone: Phone
)

data class HotelReservationInformation(
    val currencyMismatchIndicator: CurrencyMismatchIndicator,
    val amount: String,
    val currency: String, // 4217
    val checkInDate: String,
    val checkInTime: String,
    val checkOutDate: String,
    val checkOutTime: String,
    val rooms: Room
)

data class Room(
    val bedType: BedType,
    val roomOccupancy: String,
    val roomType: RoomType
)

enum class BedType(val type: String){
    @JsonProperty("01") KING("01"),
    @JsonProperty("02") QUEEN_OR_DOUBLE("02"),
    @JsonProperty("03") TWIN("03"),
    @JsonProperty("04") OTHER("04"),

}

enum class RoomType(val type: String){
    @JsonProperty("01") SINGLE("01"),
    @JsonProperty("02") DOUBLE("02"),
    @JsonProperty("03") TRIPLE("03"),
    @JsonProperty("04") QUAD("04"),
    @JsonProperty("05") KING("05"),
    @JsonProperty("06") DOUBLE_DOUBLE("06"),
    @JsonProperty("07") TWIN("07"),
    @JsonProperty("08") STUDIO("08"),
    @JsonProperty("09") MASTER_SUITE("09"),
    @JsonProperty("10") MINI_OR_JUNIOR_SUITE("10"),
    @JsonProperty("11") OTHER("11")
}