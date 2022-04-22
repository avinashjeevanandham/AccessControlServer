package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue
import com.fasterxml.jackson.annotation.JsonProperty

data class CarRentalData(
    val companyInfo: CompanyInformation,
    val reservationInfo: CarReservationInformation
)

data class CompanyInformation(
    val name: String,
    val email: String, // rfc 5233
    val phone: Phone
)
data class CarReservationInformation(
    val currencyMismatchIndicator: CurrencyMismatchIndicator,
    val amount: String,
    val currency: String, // 4217
    val pickUpDate: String,
    val pickUpTime: String,
    val pickUpLocation: Location,
    val returnDate: String,
    val returnTime: String,
    val returnLocation:Location,
    val cars: Car

)
data class Location(
    val addrLine1: String,
    val addrLine2: String,
    val addrLine3: String,
    val addrCity: String,
    val addrState: String, // iso 3166-2
    val addrPostCode: String,
    val addrCountry: String // iso 3166-1
)

data class Car(
    val carRentalType: Any,
    val carRentalInsuranceType: Any
)

enum class CurrencyMismatchIndicator(val indicator: String){
    @JsonProperty("Y") YES("Y"),
    @JsonProperty("N")
    @JsonEnumDefaultValue
    NO("N")
}