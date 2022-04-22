package one.upswing.acs.models

data class MerchantRiskIndicator (
    val shipIndicator: ShippingIndicator,
    val deliveryTimeframe: DeliveryTimeFrame,
    val deliveryEmailAddress: String,
    val reorderItemsInd: ReorderItemsIndicator,
    val preOrderPurchaseInd: PreOrderPurchaseIndicator,
    val preOrderDate: String,
    val giftCardAmount: String,
    val giftCardCurr: String,
    val giftCardCount: String
    ) {}

enum class DeliveryTimeFrame(val timeFrame:String) {
    ELECTRONIC_DELIVERY("01"),
    SAME_DAY_SHIPPING("02"),
    OVERNIGHT_SHIPPING("03"),
    TWO_DAY_OR_MORE_SHIPPING("04")
}

enum class PreOrderPurchaseIndicator(val indicator: String) {
    MERCHANDISE_AVAILABLE("01"),
    FUTURE_AVAILABILITY("02")
}

enum class ReorderItemsIndicator(val indicator: String) {
    FIRST_TIME_ORDERED("01"),
    REORDERED("02")
}
enum class ShippingIndicator(val indicator: String) {
    CARDHOLDER_BILLING_ADDRESS("01"),
    ANOTHER_VERIFIED_ADDRESS_ON_FILE_WITH_MERCHANT("02"),
    ADDRESS_THAT_IS_DIFFERENT_THAN_THE_CARDHOLDERS_BILLING_ADDRESS("03"),
    SHIP_TO_STORE("04"),
    DIGITAL_GOODS("05"),
    TRAVEL_AND_EVENT_TICKETS("06"),
    OTHER("07"),
    PICKUP_AND_GO_DELIVERY("08"),
    LOCKER_DELIVERY("09")
}