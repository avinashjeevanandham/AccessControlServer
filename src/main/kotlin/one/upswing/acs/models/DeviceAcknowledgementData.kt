package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ThreeDSDeviceAcknowledgementData(
    val version: String,
    val sdkAuthenticationType: SDKAuthenticationType,
    val sdkServerSignedContent: String,
    val sdkSignatureTimestamp: String,
    val sdkType: SDKType,
    val splitSdkServerID: String,
)


enum class SDKAuthenticationType( val method: String){
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
    @JsonProperty("11") PUSH_CONFIRMATION("11")
}

data class ACSDeviceAcknowledgementData (
    val version: String,
    val authenticationMethod: SDKAuthenticationType,
    val deviceInfoRecognisedVersion: String,
    val deviceUserInterfaceMode: DeviceUIMode
    )