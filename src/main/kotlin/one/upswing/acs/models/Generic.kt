package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

enum class MessageType(val type: String) {
    @JsonProperty("AReq") AUTHENTICATION_REQUEST("AReq"),
    @JsonProperty("ARes") AUTHENTICATION_RESPONSE("ARes"),
    @JsonProperty("CReq") CHALLENGE_REQUEST("CReq"),
    @JsonProperty("CRes") CHALLENGE_RESPONSE("CRes"),
    @JsonProperty("OReq") OPERATION_REQUEST("OReq"),
    @JsonProperty("ORes") OPERATION_RESPONSE("ORes"),
    @JsonProperty("PReq") PREPARATION_REQUEST("PReq"),
    @JsonProperty("PRes") PREPARATION_RESPONSE("PRes"),
    @JsonProperty("RReq") RESULTS_REQUEST("RReq"),
    @JsonProperty("RRes") RESULTS_RESPONSE("RRes"),
    @JsonProperty("Erro") ERROR_MESSAGE("Erro")
}

enum class Severity(val info: String){
    @JsonProperty("01") CRITICAL("01"),
    @JsonProperty("02") MAJOR("02"),
    @JsonProperty("03") MINOR("03"),
    @JsonProperty("04") INFORMATIONAL("04")
}

data class ACSRenderingType(
    val acsInterface: ACSInterface,
    val acsUiTemplate:ACSUITemplate,
    val deviceUserInterfaceMode: DeviceUIMode
)

enum class AuthenticationMethod( val method: String){
    @JsonProperty("01") STATIC_PASSCODE("01"),
    @JsonProperty("02") SMS_OTP("02"),
    @JsonProperty("03") KEY_FOB_OR_EMV_CARD_READER_TOP("03"),
    @JsonProperty("04") APP_OTP("04"),
    @JsonProperty("05") OTP_OTHER("05"),
    @JsonProperty("06") KBA("06"),
    @JsonProperty("07") OOB_BIOMETRICS("07"),
    @JsonProperty("08") OOB_LOGIN("08"),
    @JsonProperty("09") OOB_OTHER("09"),
    @JsonProperty("10") OTHER("10"),
    @JsonProperty("11") PUSH_CONFIRMATION("11"),
    @JsonProperty("12") DECOUPLED("12"),
    @JsonProperty("13") WEBAUTHN("13"),
    @JsonProperty("14") SPC("14"),
    @JsonProperty("15") BEHAVIOURAL_BIOMETRICS("15")
}

data class BroadCastInformation(
    val category: BroadcastInfoCategory,
    val description: String,
    val expDate: String,
    val severity: Severity,
    val recipients: BroadcastInfoRecipients,
    val source: Source
)

enum class Source(val info: String){
    @JsonProperty("01") THREE_DS_SERVER("01"),
    @JsonProperty("02") DS("02"),
    @JsonProperty("03") ACS("03")
}

enum class BroadcastInfoCategory(val info: String){
    @JsonProperty("01") GENERAL("01"),
    @JsonProperty("02") CERTIFICATE_EXPIRY("02"),
    @JsonProperty("03") FRAUD_ALERT("03"),
    @JsonProperty("04") OPERATIONAL_ALERT("04"),
    @JsonProperty("05") TRANSACTIONAL_DATA("05"),
    @JsonProperty("06") OTHER("06"),
}


enum class BroadcastInfoRecipients(val info: String){
    @JsonProperty("01") THREE_DS_SDK("01"),
    @JsonProperty("02") THREE_DS_SERVER("02"),
    @JsonProperty("03") DS("03"),
    @JsonProperty("04") ACS("04")
}


data class CardHolderInfo(
    val text: String,
    val issuerImage: String,
    val paymentSystemImage: String
)

enum class ChallengeCancellationIndicator(val indicator: String) {
    @JsonProperty("01") CARD_HOLDER_SELECTED_CANCEL("01"),
    @JsonProperty("03") TRANSACTION_TIMED_OUT_DECOUPLED_AUTH("03"),
    @JsonProperty("04") TRANSACTION_TIMEOUT_AT_ACS_OTHER("04"),
    @JsonProperty("05") TRANSACTION_TIMEOUT_AT_ACS_FIRST_CREQ_NOT_RECEIVED("05"),
    @JsonProperty("06") TRANSACTION_ERROR("06"),
    @JsonProperty("07") UNKNOWN("07"),
    @JsonProperty("08") TRANSACTION_TIMEOUT_AT_3DS_SDK("08"),
    @JsonProperty("09") ERROR_MESSAGE_IN_RESPONSE_TO_CRES("09"),
    @JsonProperty("10") ERROR_MESSAGE_IN_RESPONSE_TO_CREQ("10")
}

enum class DeviceBindingStatus(val status: String){
    @JsonProperty("01") NOT_BOUND_BY_CARD_HOLDER("01"),
    @JsonProperty("02") NOT_ELIGIBLE_("02"),
    @JsonProperty("03") PENDING_CONFIRMATION_BY_CARD_HOLDER("03"),
    @JsonProperty("04") CARD_HOLDER_REJECTED("04"),
    @JsonProperty("05") UNKNOWN_OR_DOES_NOT_APPLY("05"),
    @JsonProperty("11") BOUND_BY_CARD_HOLDER_INTERNAL("11"),
    @JsonProperty("12") BOUND_BY_CARD_HOLDER_EXTERNAL("12"),
    @JsonProperty("13") BOUND_BY_CARD_HOLDER_DYNAMIC("13"),
    @JsonProperty("14") BOUND_BY_CARD_HOLDER_STATIC("14"),
    @JsonProperty("15") BOUND_BY_CARD_HOLDER_OTHER("15")
}

enum class MessageCategory(val category: String) {
    @JsonProperty("01") PAYMENT_AUTHENTICATION("01"),
    @JsonProperty("02") NON_PAYMENT_AUTHENTICATION("02"),
}

enum class TransactionStatusReason (val reason: String) {
    @JsonProperty("01") CARD_AUTHENTICATION_FAILED("01"),
    @JsonProperty("02") UNKNOWN_DEVICE("02"),
    @JsonProperty("03") UNSUPPORTED_DEVICE("03"),
    @JsonProperty("04") EXCEEDS_AUTHENTICATION_FREQUENCY_LIMIT("04"),
    @JsonProperty("05") EXPIRED_CARD("05"),
    @JsonProperty("06") INVALID_CARD_NUMBER("06"),
    @JsonProperty("07") INVALID_TRANSACTION("07"),
    @JsonProperty("08") NO_CARD_RECORD("08"),
    @JsonProperty("09") SECURITY_FAILURE("09"),
    @JsonProperty("10") STOLEN_CARD("10"),
    @JsonProperty("11") SUSPECTED_FRAUD("11"),
    @JsonProperty("12") TRANSACTION_NOT_PERMITTED_TO_CARD_HOLDER("12"),
    @JsonProperty("13") CARD_HOLDER_NOT_ENROLLED_IN_SERVICE("13"),
    @JsonProperty("14") TRANSACTION_TIMED_OUT_AT_ACS("14"),
    @JsonProperty("15") LOW_CONFIDENCE("15"),
    @JsonProperty("16") MEDIUM_CONFIDENCE("16"),
    @JsonProperty("17") HIGH_CONFIDENCE("17"),
    @JsonProperty("18") VERY_HIGH_CONFIDENCE("18"),
    @JsonProperty("19") EXCEEDS_ACS_MAX_CHALLENGES("19"),
    @JsonProperty("20") NON_PAYMENT_TRANSACTION_NOT_SUPPORTED("20"),
    @JsonProperty("21") THREE_RI_TRANSACTION_NOT_SUPPORTED("21"),
    @JsonProperty("22") ACS_TECHNICAL_ISSUE("22"),
    @JsonProperty("23") DECOUPLED_AUTH_REQUIRED_BY_ACS_BUT_NOT_REQUESTED_BY_3DS("23"),
    @JsonProperty("24") THREE_DS_REQUESTOR_DECOUPLED_MAX_EXPIRY_TIME_EXCEEDED("24"),
    @JsonProperty("25") DECOUPLED_AUTHENTICATION_WAS_PROVIDED_INSUFFICIENT_TIME_TO_AUTHENTICATE_CARDHOLDER_ACS_WILL_NOT_MAKE_ATTEMPT("25"),
    @JsonProperty("26") AUTHENTICATION_ATTEMPTED_BUT_NOT_PERFORMED_BY_CARD_HOLDER("26"),
    @JsonProperty("27") PREFERRED_AUTHENTICATION_METHOD_NOT_SUPPORTED("27"),
}
enum class TransactionStatus(val status: String) {
    @JsonProperty("Y") SUCCESSFUL("Y"),
    @JsonProperty("N") NOT_AUTHENTICATED_OR_ACCOUNT_NOT_VERIFIED_OR_TRANSACTION_DENIED("N"),
    @JsonProperty("U") AUTHENTICATION_OR_ACCOUNT_VERIFICATION_COULD_NOT_BE_PERFORMED("U"),
    @JsonProperty("A") ATTEMPTS_PROCESSING_PERFORMED("A"),
    @JsonProperty("C") CHALLENGE_REQUIRED("C"),
    @JsonProperty("D") CHALLENGE_REQUIRED_DECOUPLED("D"),
    @JsonProperty("R") ISSUER_REJECTED("R"),
    @JsonProperty("I") INFORMATION_ONLY("I"),
    @JsonProperty("S") CHALLENGE_USING_SPC("S")
}

enum class TrustListStatus(val status: String) {
    @JsonProperty("Y") TRUSTED_BY_CARD_HOLDER("Y"),
    @JsonProperty("N") NOT_TRUSTED_BY_CARD_HOLDER("N"),
    @JsonProperty("E") NOT_ELIGIBLE("E"),
    @JsonProperty("P") PENDING_CONFIRMATION_BY_CARD_HOLDER("P"),
    @JsonProperty("R") CARD_HOLDER_REJECTED("R"),
    @JsonProperty("U") UNKNOWN_OR_UNAVAILABLE_DOES_NOT_APPLY("U"),
}

data class Phone(val cc: String, val subscriber: String)
