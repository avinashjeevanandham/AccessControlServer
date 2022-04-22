package one.upswing.acs.models

data class MessageExtension(val messageExtension: List<MessageExtensionData>) {
}

data class MessageExtensionData(
    val name: String,
    val id: String,
    val criticalityIndicator: Boolean,
    val data: Map<String, String>
    ){}

data class TravelIndustryMessageExtensionData(
    val name: String,
    val id: String,
    val criticalityIndicator: Boolean,
    val data: Map<String, String>
)

data class TravelIndustryData(
    val agencyIndicator: Indicator,
    val air: AirTravelData,
    val car: CarRentalData,
    val hotel: HotelData,
    val travellers: TravellerData,
    val version: String,


)