package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ChallengeRequest(
    val threeDSRequestorAppURL: String,
    val threeDSServerTransID: String,
    val acsTransID: String,
    val challengeAddCode: ChallengeAdditionalCode,
    val challengeCancel: ChallengeCancellationIndicator,
    val challengeDataEntry: String,
    val challengeDataEntryTwo: String,
    val challengeHTMLDataEntry: String,
    val challengeNoEntry: ChallengeNoEntry,
    val challengeWindowSize: ChallengeWindowSize,
    val deviceBindingDataEntry: Consent,
    val infoContinueIndicator: Boolean,
    val messageExtension: MessageExtension,
    val messageType: MessageType,
    val messageVersion: String,
    val oobAppStatus: OOBAppStatus,
    val oobContinue: OOBContinuationIndicator,
    val resendChallenge: ResendChallengeInformationCode,
    val sdkTransID: String,
    val sdkCounterStoA: String,
    val trustListDataEntry: Consent
)

enum class OOBContinuationIndicator(val indicator: String){
    @JsonProperty("01") CARD_HOLDER_CLICKS_BUTTON("01"),
    @JsonProperty("02") AUTOMATIC_COMPLETE("02"),
}
enum class OOBAppStatus(val status: String){
    @JsonProperty("01") OPEN_OOB_APP_URL_FAILED("01")
}
enum class Consent(val consent: String){
    @JsonProperty("01") CONSENT_GIVEN("01"),
    @JsonProperty("02") CONSENT_NOT_GIVEN("02"),
}

enum class ChallengeWindowSize(val size: String){
    @JsonProperty("01") _250_X_400("01"),
    @JsonProperty("02") _390_X_400("02"),
    @JsonProperty("03") _500_X_600("03"),
    @JsonProperty("04") _600_X_600("04"),
    @JsonProperty("05") FULL_SCREEN("05"),
}
enum class ChallengeAdditionalCode(val code: String) {
    @JsonProperty("Y") YES("Y"),
    @JsonProperty("N") NO("N")
}
enum class ChallengeNoEntry(val indicator: String){
    @JsonProperty("Y") NO_DATA_ENTRY("Y")
}

enum class ResendChallengeInformationCode(val indicator: String){
    @JsonProperty("Y") RESEND("Y")
}