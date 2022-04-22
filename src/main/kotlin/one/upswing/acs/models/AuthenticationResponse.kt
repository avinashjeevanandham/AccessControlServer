package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthenticationResponse(
    val threeDSServerTransID: String,
    val acsChallengeMandated: ChallengeMandateIndicator,
    val acsDecConInd: ACSDecoupledConfirmationIndicator,
    val acsOperatorID: String,
    val acsReferenceNumber: String,
    val acsRenderingType: ACSRenderingType,
    val acsSignedContent: String,
    val acsTransID: String,
    val acsURL: String,
    val authenticationMethod: AuthenticationMethod,
    val authenticationValue: String,
    val broadInfo: BroadCastInformation,
    val cardholderInfo: CardHolderInfo,
    val cardSecurityCodeStatusSource: CardSecurityCodeStatusSource,
    val cardSecurityCodeStatus: CardSecurityCodeStatus,
    val deviceBindingStatus: DeviceBindingStatus,
    val deviceBindingStatusSource: Source,
    val deviceInfoRecognisedVersion: String,
    val dsReferenceNumber: String,
    val dsTransID: String,
    val eci: String,
    val messageExtension: MessageExtension,
    val messageType: MessageType,
    val messageVersion: String,
    val sdkTransID: String,
    val spcTransData: SPCTransactionData,
    val transChallengeExemption: TransactionChallengeExemption,
    val transStatus: TransactionStatus,
    val transStatusReason: TransactionStatusReason,
    val transStatusReasonInfo: String,
    val trustListStatus: TrustListStatus,
    val trustListStatusSource: Source,
    val webAuthnCredList: List<String>
)

enum class TransactionChallengeExemption(val exemption: String) {
    @JsonProperty("05") RISK_ANALYSIS_EXEMPTION("05"),
    @JsonProperty("08") TRUST_LIST_EXEMPTION("08"),
    @JsonProperty("10") LOW_VALUE_EXEMPTION("10"),
    @JsonProperty("11") SECURE_CORPORATE_PAYMENTS_EXEMPTION("11"),
    @JsonProperty("79") NO_EXEMPTION("79")
}
data class SPCTransactionData (
    val merchantSpcName: String,
    val amountSpc: String,
    val amountCurrencySpc: String,
    val cardArt: String,
    val cardArtName: String,
    val issuerImageSpc: Image,
    val psImageSpc: Image,
    val spcUniqueRandomNumber: String
    )

data class Image(
    val default: String,
    val dark: String,
    val monochrome: String
)

enum class ACSInterface(val ui: String) {
    @JsonProperty("01") NATIVE_UI("01"),
    @JsonProperty("02") HTML_UI("02"),
}

enum class ACSUITemplate(val template: String){
    @JsonProperty("01") TEXT("01"),
    @JsonProperty("02") SINGLE_SELECT("02"),
    @JsonProperty("03") MULTI_SELECT("03"),
    @JsonProperty("04") OOB("04"),
    @JsonProperty("05") HTML_OTHER("05"),
    @JsonProperty("06") HTML_OOB("06"),
    @JsonProperty("07") INFORMATION("07")
}
enum class DeviceUIMode(val mode: String){
    @JsonProperty("01") PORTRAIT("01"),
    @JsonProperty("02") LANDSCAPE("02"),
    @JsonProperty("03") VOICE("03"),
    @JsonProperty("04") OTHER("04")
}
enum class ChallengeMandateIndicator(val indicator: String) {
    @JsonProperty("Y") MANDATED("Y"),
    @JsonProperty("N") NOT_MANDATED("N")
}
enum class ACSDecoupledConfirmationIndicator(val indicator: String) {
    @JsonProperty("Y") UTILISED("Y"),
    @JsonProperty("N") NOT_UTILISED("N")
}



enum class CardSecurityCodeStatusSource(val source: String){
    @JsonProperty("01") DS("01"),
    @JsonProperty("02") ACS("02")
}

enum class  CardSecurityCodeStatus(val status: String) {
    @JsonProperty("Y") VALIDATED("Y"),
    @JsonProperty("N") VALIDATION_FAILED("N"),
    @JsonProperty("U") UNKNOWN_OR_DOES_NOT_APPLY("U")
}
