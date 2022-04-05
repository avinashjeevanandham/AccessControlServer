package one.upswing.acs.model

data class Phone(val cc: String, val subscriber: String)

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


data class AuthenticationRequestApp(
    val threeDSRequestorID: String,
    val threeDSRequestorName: String,
    val threeDSRequestorURL: String,
    val acquirerBIN: String,
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
    val messageType: String,
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
    val threeDSRequestorChallengeInd: ThreeDSRequestorChallengeIndicator,
    val threeDSRequestorPriorAuthenticationInfo: Unit,
    val threeDSServerOperatorID: String,
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
) {
}

enum class ThreeDSRequestorChallengeIndicator(val indicator: String) {
    NO_PREFERENCE("01"),
    NO_CHALLENGE_REQUESTED("02"),
    CHALLENGE_REQUESTED_3DS_REQUESTOR_PREFERENCE("03"),
    CHALLENGE_REQUESTED_MANDATE("04"),
    NO_CHALLENGE_REQUESTED_TXN_RISK_ANALYSIS_ALREADY_PERFORMED("05"),
    NO_CHALLENGE_REQUESTED_DATA_SHARE_ONLY("06"),
    NO_CHALLENGE_REQUESTED_STRONG_CONSUMER_AUTHENTICATION_IS_ALREADY_PERFORMED("07"),
    NO_CHALLENGE_REQUESTED_UTILISE_TRUST_LIST_EXEMPTION_IF_NO_CHALLENGE_REQUIRED("08"),
    CHALLENGE_REQUESTED_TRUST_LIST_PROMPT_REQUESTED_IF_CHALLENGE_REQUIRED("09"),
    NO_CHALLENGE_REQUESTED_UTILISE_LOW_VALUE_EXEMPTION("10"),
    NO_CHALLENGE_REQUESTED_SECURE_CORPORATE_PAYMENT_EXEMPTION("11"),
    CHALLENGE_REQUESTED_DEVICE_BINDING_PROMPT_REQUESTED_IF_CHALLENGE_REQUIRED("12"),
    CHALLENGE_REQUESTED_ISSUER_REQUESTED("13"),
    CHALLENGE_REQUESTED_MERCHANT_INITIATED_TRANSACTIONS("14")
}

