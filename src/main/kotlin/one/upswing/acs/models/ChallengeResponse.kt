package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ChallengeResponse(
    val threeDSServerTransID: String,
    val acsCounterAtoS: String,
    val acsTransID: String,
    val acsHTML: String,
    val acsUiType:  ACSUITemplate,
    val challengeAddLabel: String,
    val challengeCompletionInd: ChallengeCompletionIndicator,
    val challengeEntryBox: ChallengeEntryBox,
    val challengeEntryBoxTwo: ChallengeEntryBox,
    val challengeInfoHeader: String,
    val challengeInfoLabel: String,
    val challengeInfoText: String,
    val challengeInfoTextIndicator: ChallengeInfoTextIndicator,
    val challengeSelectInfo: List<Map<String, String>>,
    val deviceBindingInfoText: String,
    val expandInfoLabel: String,
    val expandInfoText: String,
    val infoContinueLabel: String,
    val issuerImage: Image,
    val messageExtension: MessageExtension,
    val messageType: MessageType,
    val messageVersion: String,
    val oobAppURL: String,
    val oobAppLabel: String,
    val oobContinueLabel: String,
    val psImage: Image,
    val resendInformationLabel: String,
    val sdkTransID: String,
    val submitAuthenticationLabel: String,
    val togglePositionInd: TogglePositionIndicator,
    val trustListInfoText: String,
    val whyInfoLabel: String,
    val whyInfoText: String
)

enum class TogglePositionIndicator(val position: String) {
    @JsonProperty("01") ABOVE_THE_BUTTONS("01")
}

enum class ChallengeInfoTextIndicator(val indicator: String) {
    @JsonProperty("Y") DISPLAY_INDICATOR("Y"),
    @JsonProperty("N") DO_NOT_DISPLAY_INDICATOR("N")
}

data class ChallengeEntryBox(
    val challengeDataEntryKeyboardType: KeyboardType,
    val challengeDataEntryAutofill: Autofill,
    val challengeDataEntryAutofillType: ChallengeDataEntryAutofillType,
    val challengeDataEntryLengthMax: String,
    val challengeDataEntryLabel: String,
    val challengeDataEntryMasking: ChallengeDataEntryMasking,
    val challengeDataEntryToggle: ChallengeDataEntryToggle
)

enum class ChallengeDataEntryToggle(val toggle: String) {
    @JsonProperty("01") DISPLAY_TOGGLE("01"),
    @JsonProperty("02") DO_NOT_DISPLAY_TOGGLE("02")
}

enum class ChallengeDataEntryMasking(val type: String) {
    @JsonProperty("01") MASK_DATA("01"),
    @JsonProperty("02") DO_NOT_MASK_DATA("02")
}

enum class Autofill(val indicator: String) {
    @JsonProperty("Y") AUTOFILL_SUPPORTED_FOR_THE_CHALLENGE("Y")
}

enum class ChallengeDataEntryAutofillType(val type: String) {
    @JsonProperty("01") SMS_OTP("01"),
    @JsonProperty("02") PASSWORD("02")
}
enum class KeyboardType(val type: String) {
    @JsonProperty("01") NUMERIC_KEYBOARD("01"),
    @JsonProperty("02") ALPHA_NUMERIC_KEYBOARD("02")
}

enum class ChallengeCompletionIndicator(val indicator: String) {
    @JsonProperty("Y") CHALLENGE_COMPLETED("Y"),
    @JsonProperty("N") CHALLENGE_NOT_COMPLETED("N")
}
