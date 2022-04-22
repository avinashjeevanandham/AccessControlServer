package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class AirTravelData(
    val airlineTicketInfo: AirlineTicketInfo,
    val itineraryInfo: ItineraryInfo
)

data class AirlineTicketInfo(
    val currencyMismatchIndicator: String = "N",
    val ticketAmount: String,
    val ticketCount: String,
    val ticketCurrency: Any
)

data class ItineraryInfo(
    val flightIndicator: FlightIndicator,
    val segments: Segments
)

enum class FlightIndicator(val indicator: String) {
    @JsonProperty("01") ONE_WAY("01"),
    @JsonProperty("02") ROUND_TRIP("02"),
    @JsonProperty("03") MULTI_CITY("03")
}

data class Segments (
    val arrivalAirport: Any, // todo
    val arrivalDate: String,
    val arrivalTime: String,
    val departureAirport: Any, //todo
    val departureDate: String,
    val departureTime: String,
    val operatingCarrier: Any // todo
    )