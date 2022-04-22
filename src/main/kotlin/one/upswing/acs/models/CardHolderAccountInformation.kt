package one.upswing.acs.models

data class CardHolderAccountInformation(
    val chAccAgeInd: AccountAgeIndicator,
    val chAccDate: String,
    val chAccChangeInd: CardHolderAccountChangeIndicator,
    val chAccChange: String,
    val chAccPwChangeInd: CardHolderAccountPasswordChangeIndicator,
    val chAccPwChange: String,
    val shipAddressUsageInd: ShippingAddressUsageIndicator,
    val shipAddressUsage: String,
    val txnActivityDay: String,
    val txnActivityYear: String,
    val provisionAttemptsDay: String,
    val nbPurchaseAccount: String,
    val suspiciousAccActivity: SuspiciousAccountActivity,
    val shipNameIndicator: ShippingNameIndicator,
    val paymentAccInd: AccountAgeIndicator,
    val paymentAccAge: String
    ) {}


enum class AccountAgeIndicator(val indicator: String){
    NO_ACCOUNT("01"),
    CREATED_DURING_THIS_TRANSACTION("02"),
    LESS_THAN_THIRTY_DAYS("03"),
    THIRTY_TO_SIXTY_DAYS("04"),
    MORE_THAN_SIXTY_DAYS("05")
}

enum class CardHolderAccountChangeIndicator(val indicator: String){
    CHANGED_DURING_THIS_TRANSACTION("01"),
    LESS_THAN_THIRTY_DAYS("02"),
    THIRTY_TO_SIXTY_DAYS("03"),
    MORE_THAN_SIXTY_DAYS("04")
}

enum class CardHolderAccountPasswordChangeIndicator(val indicator: String) {
    NO_CHANGE("01"),
    CHANGED_DURING_THIS_TRANSACTION("02"),
    LESS_THAN_THIRTY_DAYS("03"),
    THIRTY_TO_SIXTY_DAYS("04"),
    MORE_THAN_SIXTY_DAYS("05")
}

enum class ShippingAddressUsageIndicator(val indicator: String) {
    THIS_TRANSACTION("01"),
    LESS_THAN_THIRTY_DAYS("02"),
    THIRTY_TO_SIXTY_DAYS("03"),
    MORE_THAN_SIXTY_DAYS("04")
}

enum class ShippingNameIndicator(val indicator: String) {
    ACCOUNT_NAME_IDENTICAL_TO_SHIPPING_NAME("01"),
    ACCOUNT_NAME_DIFFERENT_THAN_SHIPPING_NAME("02")
}

enum class SuspiciousAccountActivity(val indicator: String){
    NO_SUSPICIOUS_ACTIVITY_HAS_BEEN_OBSERVED("01"),
    SUSPICIOUS_ACTIVITY_HAS_BEEN_OBSERVED("02")
}