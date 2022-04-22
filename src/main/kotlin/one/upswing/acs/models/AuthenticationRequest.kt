package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue
import com.fasterxml.jackson.annotation.JsonProperty
import com.neovisionaries.i18n.CountryCode
import javax.validation.constraints.Size


data class DeviceRenderOptions(
    val sdkInterface: String,
    val sdkAuthenticationType: String,
    val sdkUiType: String
    ){}

data class SDKEphemeralPublicKey(
    val kty: String,
    val crv: String,
    val x: String,
    val y: String
    ){}

data class AuthenticationRequest(
    val threeDSCompInd: ThreeDSMethodCompletionIndicator,
    val threeDSMethodId: String,
    val threeDSRequestorID: String,
    val threeDSRequestorName: String,
    val threeDSRequestorURL: String,
    val acquirerBIN: String,
    val acquirerCountryCode: CountryCode,
    val acquirerMerchantID: String,
    val addrMatch: String,
    val cardExpiryDate: String,
    val acctNumber: String,
    val billAddrCity: String,
    val billAddrCountry: String,
    val billAddrLine1: String,
    val billAddrLine2: String,
    val billAddrLine3: String,
    val billAddrPostCode: String,
    val billAddrState: String,
    val email: String,
    val homePhone: Phone,
    val mobilePhone: Phone,
    val cardholderName: String,
    val shipAddrCity: String,
    val shipAddrCountry: String,
    val shipAddrLine1: String,
    val shipAddrLine2: String,
    val shipAddrLine3: String,
    val shipAddrPostCode: String,
    val shipAddrState: String,
    val workPhone: Phone,
    val deviceChannel: String,
    val deviceRenderOptions: DeviceRenderOptions,
    val mcc: String,
    val merchantCountryCode: String,
    val merchantName: String,
    val messageCategory: String,
    val messageType: MessageType,
    val messageVersion: String,
    val purchaseAmount: String,
    val purchaseCurrency: String,
    val purchaseExponent: String,
    val purchaseDate: String,
    val sdkAppID: String,
    val sdkMaxTimeout: String,
    val sdkEphemPubKey: SDKEphemeralPublicKey,
    val sdkReferenceNumber: String,
    val sdkTransID: String,
    val transType: String,
    val threeDSServerURL: String,
    val threeDSServerTransID: String,
    val threeDSServerRefNumber: String,
    val threeDSRequestorAuthenticationInd: String,
    val threeDSRequestorAuthenticationInfo: Unit,
    val threeDSReqAuthMethodInd: ThreeDSAuthenticationMethodVerificationIndicator,
    val threeDSRequestorChallengeInd: ThreeDSRequestorChallengeIndicator,
    val threeDSRequestorDecMaxTime: String,
    val threeDSRequestorDecReqInd: ThreeDSRequestorDecoupledRequestIndicator,
    val threeDSRequestorPriorAuthenticationInfo: ThreeDSRequestorPriorTransactionAuthInfo,
    val threeDSRequestorSpcSupport: ThreeDSRequestorSPCSupport,
    val threeDSServerOperatorID: String,
    val threeRIInd: ThreeRIIndicator,
    val acctType: String,
    val acctInfo: CardHolderAccountInformation,
    val acctID: String,
    val dsReferenceNumber: String,
    val dsTransID: String,
    val dsURL: String,
    val payTokenInd: Boolean,
    val messageExtension: MessageExtension,
    val purchaseInstalData: String,
    val recurringExpiry: String,
    val recurringFrequency: String,
    val broadInfo: Any,
    val deviceInfo: Any
)

data class ThreeDSRequestorPriorTransactionAuthInfo(
    val threeDSReqPriorAuthData: String,
    val threeDSReqPriorAuthMethod: ThreeDSRequestorPriorAuthMethod,
    val threeDSReqPriorAuthTimestamp: String,
    val threeDSReqPriorRef: String
){}

enum class ThreeDSRequestorSPCSupport(val indicator: String) {
    @JsonProperty("Y") SUPPORTED("Y")
}
enum class ThreeDSRequestorPriorAuthMethod(val method: String) {
    @JsonProperty("01") FRICTIONLESS_AUTH("01"),
    @JsonProperty("02") CHALLENGE_PERFORMED("02"),
    @JsonProperty("03") AVS_VERIFIED("03"),
    @JsonProperty("04") OTHER_ISSUER_METHODS("04"),
    @JsonProperty("05") SPC_AUTH("05")
}
enum class ThreeRIIndicator(val indicator: String) {
    @JsonProperty("01") RECURRING_TRANSACTION("01"),
    @JsonProperty("02") INSTALLMENT_TRANSACTION("02"),
    @JsonProperty("03") ADD_CARD("03"),
    @JsonProperty("04") MAINTAIN_CARD_INFO("04"),
    @JsonProperty("05") ACCOUNT_VERIFICATION("05"),
    @JsonProperty("06") SPLIT_OR_DELAYED_SHIPMENT("06"),
    @JsonProperty("07") TOP_UP("07"),
    @JsonProperty("08") MAIL_ORDER("08"),
    @JsonProperty("09") TELEPHONE_ORDER("09"),
    @JsonProperty("10") TRUST_LIST_STATUS_CHECK("10"),
    @JsonProperty("11") OTHER_PAYMENT("11"),
    @JsonProperty("12") BILLING_AGREEMENT("12"),
    @JsonProperty("13") DEVICE_BINDING_STATUS_CHECK("13"),
    @JsonProperty("14") CARD_SECURITY_STATUS_CHECK("14");
    //@JsonEnumDefaultValue RESERVED("");



    companion object{

        private val enumMap: HashMap<String, ThreeRIIndicator> = HashMap<String, ThreeRIIndicator>();

        init {
            println("init.......")
            for (item in ThreeRIIndicator.values()) {
                enumMap[item.indicator] = item
            }
        }
        @JsonCreator
        @JvmStatic
        fun from(value: String): ThreeRIIndicator? {
            println("Its working")
            println(value)
            val indicatorValue: Int = value.toInt()
            if (indicatorValue in 15..79) throw Exception("Reserved for EMVCo use")
            if (indicatorValue in 80..99) throw Exception("Reserved for EMVCo use")
            if (indicatorValue > 99) throw Exception("Invalid value")
            return enumMap[value]
        }
    }

}
enum class ThreeDSAuthenticationMethodVerificationIndicator(val indicator: String){
    @JsonProperty("01") VERIFIED("01"),
    @JsonProperty("02") FAILED("02"),
    @JsonProperty("03") NOT_PERFORMED("03")
}
enum class ThreeDSRequestorChallengeIndicator(val indicator: String) {
    @JsonProperty("01") NO_PREFERENCE("01"),
    @JsonProperty("02") NO_CHALLENGE_REQUESTED("02"),
    @JsonProperty("03") CHALLENGE_REQUESTED_3DS_REQUESTOR_PREFERENCE("03"),
    @JsonProperty("04") CHALLENGE_REQUESTED_MANDATE("04"),
    @JsonProperty("05") NO_CHALLENGE_REQUESTED_TXN_RISK_ANALYSIS_ALREADY_PERFORMED("05"),
    @JsonProperty("06") NO_CHALLENGE_REQUESTED_DATA_SHARE_ONLY("06"),
    @JsonProperty("07") NO_CHALLENGE_REQUESTED_STRONG_CONSUMER_AUTHENTICATION_IS_ALREADY_PERFORMED("07"),
    @JsonProperty("08") NO_CHALLENGE_REQUESTED_UTILISE_TRUST_LIST_EXEMPTION_IF_NO_CHALLENGE_REQUIRED("08"),
    @JsonProperty("09") CHALLENGE_REQUESTED_TRUST_LIST_PROMPT_REQUESTED_IF_CHALLENGE_REQUIRED("09"),
    @JsonProperty("10") NO_CHALLENGE_REQUESTED_UTILISE_LOW_VALUE_EXEMPTION("10"),
    @JsonProperty("11") NO_CHALLENGE_REQUESTED_SECURE_CORPORATE_PAYMENT_EXEMPTION("11"),
    @JsonProperty("12") CHALLENGE_REQUESTED_DEVICE_BINDING_PROMPT_REQUESTED_IF_CHALLENGE_REQUIRED("12"),
    @JsonProperty("13") CHALLENGE_REQUESTED_ISSUER_REQUESTED("13"),
    @JsonProperty("14") CHALLENGE_REQUESTED_MERCHANT_INITIATED_TRANSACTIONS("14")

}
enum class ThreeDSRequestorDecoupledRequestIndicator(val indicator: String) {
    @JsonProperty("Y") DECOUPLED_AUTHENTICATION("Y"),
    @JsonEnumDefaultValue
    @JsonProperty("N")
    NO_DECOUPLED_AUTHENTICATION("N")

}

enum class ThreeDSMethodCompletionIndicator(val indicator: String) {
    @JsonProperty("Y") SUCCESSFULLY_COMPLETED("Y"),
    @JsonProperty("N") DID_NOT_RUN_OR_UNSUCCESSFUL("N"),
    @JsonProperty("U") UNAVAILABLE("U")
}

data class Sample(
    @field:Size(min=5, max=10)
    val a: String,
    val b: String,
    val c: String)

data class Sample2 (
    val a: ThreeRIIndicator
    )

