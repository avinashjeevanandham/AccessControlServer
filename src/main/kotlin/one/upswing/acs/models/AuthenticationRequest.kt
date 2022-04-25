package one.upswing.acs.models

//import one.upswing.acs.validators.Date
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.neovisionaries.i18n.CountryCode
import one.upswing.acs.InvalidDataFormatException
import one.upswing.acs.ReservedRangeException
import one.upswing.acs.validators.UUID
import one.upswing.acs.validators.YYMM
import one.upswing.acs.validators.YYYYMMDD
import one.upswing.acs.validators.YYYYMMDDHHMM
import org.hibernate.validator.constraints.CreditCardNumber
import org.hibernate.validator.constraints.URL
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.PastOrPresent
import javax.validation.constraints.Pattern
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

enum class AddressMatchIndicator(val indicator: String) {
    @JsonProperty("Y") SHIPPING_AND_BILLING_ADDRESSES_MATCH("Y"),
    @JsonProperty("N") SHIPPING_AND_BILLING_ADDRESSES_DO_NOT_MATCH("N")
}

enum class ThreeDSReqAuthIndicator(val indicator: String) {
    @JsonProperty("01") PAYMENT_TRANSACTION("01"),
    @JsonProperty("02") RECURRING_TRANSACTION("02"),
    @JsonProperty("03") INSTALLMENT_TRANSACTION("03"),
    @JsonProperty("04") ADD_CARD("04"),
    @JsonProperty("05") MAINTAIN_CARD("05"),
    @JsonProperty("06") CARD_HOLDER_VERIFICATION("06"),
    @JsonProperty("07") BILLING_AGREEMENT("07");

    companion object{
        private val errorDetail: String = "Value should be one of ${ThreeDSReqAuthIndicator.values().map { it -> it.indicator }.toString()}"
        private val enumMap: HashMap<String, ThreeDSReqAuthIndicator> = hashMapOf<String, ThreeDSReqAuthIndicator>();

        init {
            for (item in ThreeDSReqAuthIndicator.values()) {
                enumMap[item.indicator] = item
            }
        }

        @JsonCreator
        @JvmStatic
        fun from(value: String): ThreeDSReqAuthIndicator? {
            val indicatorValue: Int =
                value.toIntOrNull() ?: throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            if (indicatorValue in 8..79) throw ReservedRangeException(RESERVED_EMVCO, errorDetail)
            if (indicatorValue in 80..99) throw ReservedRangeException(RESERVED_DS, errorDetail)
            if (indicatorValue > 99) throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            return enumMap[value]
        }
    }
}
data class ThreeDSRequestorAuthenticationInformation (
    @Size(max = 20000)
    val threeDSReqAuthData: String?,
    val threeDSReqAuthMethod: ThreeDSRequestorAuthenticationMethod,
    @JsonDeserialize(using = YYYYMMDDHHMM::class)
    val threeDSReqAuthTimestamp: String
    )

enum class ThreeDSRequestorAuthenticationMethod(val method: String) {
    @JsonProperty("01") NO_3DS_REQ_AUTH_OCCURRED("01"),
    @JsonProperty("02") THREE_DS_REQUESTOR_OWN_CREDENTIALS("02"),
    @JsonProperty("03") FEDERATED_ID("03"),
    @JsonProperty("04") ISSUER_CREDENTIALS("04"),
    @JsonProperty("05") THIRD_PARTY_AUTHENTICATION("05"),
    @JsonProperty("06") FIDO_AUTHENTICATOR("06"),
    @JsonProperty("07") FIDO_ASSERTION_OR_ATTESTATION("07"),
    @JsonProperty("08") SRC_ASSURANCE_DATA("08"),
    @JsonProperty("09") SPC_AUTHENTICATION("09");
    companion object{
        private val errorDetail: String = "Value should be one of ${ThreeDSRequestorAuthenticationMethod.values().map { it -> it.method }.toString()}"
        private val enumMap = hashMapOf<String, ThreeDSRequestorAuthenticationMethod>();

        init {
            for (item in ThreeDSRequestorAuthenticationMethod.values()) {
                enumMap[item.method] = item
            }
        }

        @JsonCreator
        @JvmStatic
        fun from(value: String): ThreeDSRequestorAuthenticationMethod? {
            val indicatorValue: Int =
                value.toIntOrNull() ?: throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            if (indicatorValue in 10..79) throw ReservedRangeException(RESERVED_EMVCO, errorDetail)
            if (indicatorValue in 80..99) throw ReservedRangeException(RESERVED_DS, errorDetail)
            if (indicatorValue > 99) throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            return enumMap[value]
        }
    }
}
data class AuthenticationRequestBrowser(
    val threeDSCompInd: ThreeDSMethodCompletionIndicator,
    val addrMatch: AddressMatchIndicator?,
    val threeDSRequestorAuthenticationInd: ThreeDSReqAuthIndicator,
    val threeDSRequestorAuthenticationInfo: List<ThreeDSRequestorAuthenticationInformation>?,
    val threeDSRequestorSpcSupport: ThreeDSRequestorSPCSupport?,
    @UUID
    val threeDSMethodId: String?,
    val spcIncompInd: SPCIncompletionIndicator?,
    @Size(max = 35)
    override val threeDSRequestorID: String,
    @Size(max = 40)
    override val threeDSRequestorName: String,
    @URL(protocol = "https")
    @Size(max = 2048)
    override val threeDSRequestorURL: String,
    @Pattern(regexp = "^[0-9]{1,11}\$")
    override val acquirerBIN: String?,
    override val acquirerCountryCode: CountryCode, // todo
    override val acquirerCountryCodeSource: AcquirerCountryCodeSource,
    @Size(max = 35)
    override val acquirerMerchantID: String,
    @JsonDeserialize(using = YYMM::class)
    override val cardExpiryDate: String?,
    @CreditCardNumber
    override val acctNumber: String,
    override val acctInfo: CardHolderAccountInformation?,
    @Size(max = 50)
    override val billAddrCity: String?,
    override val billAddrCountry: String?, //todo
    @Size(max = 50)
    override val billAddrLine1: String?,
    @Size(max = 50)
    override val billAddrLine2: String?,
    @Size(max = 50)
    override val billAddrLine3: String?,
    @Size(max = 16)
    override val billAddrPostCode: String?,
    override val billAddrState: String?, // todo
    @Size(max = 50)
    override val shipAddrCity: String?,
    override val shipAddrCountry: String?, //todo
    @Size(max = 50)
    override val shipAddrLine1: String?,
    @Size(max = 50)
    override val shipAddrLine2: String?,
    @Size(max = 50)
    override val shipAddrLine3: String?,
    @Size(max = 16)
    override val shipAddrPostCode: String?,
    override val shipAddrState: String?, //todo
    @Email
    override val email: String?,
    override val homePhone: Phone?,
    override val mobilePhone: Phone?,
    @Size(min = 1, max = 45)
    override val cardholderName: String?,
    override val workPhone: Phone?,
    override val deviceChannel: String,
    override val mcc: String?,
    override val merchantCountryCode: String?,
    override val merchantName: String?,
    override val messageCategory: String,
    override val messageType: MessageType,
    override val messageVersion: String,
    override val purchaseAmount: String?,
    override val purchaseCurrency: String?,
    override val purchaseExponent: String?,
    override val purchaseDate: String?,
    override val transType: String?,
    override val threeDSServerURL: String,
    override val threeDSServerTransID: String,
    override val threeDSServerRefNumber: String,
    override val threeDSReqAuthMethodInd: ThreeDSAuthenticationMethodVerificationIndicator?,
    override val threeDSRequestorChallengeInd: ThreeDSRequestorChallengeIndicator?,
    override val threeDSRequestorDecMaxTime: String?,
    override val threeDSRequestorDecReqInd: ThreeDSRequestorDecoupledRequestIndicator?,
    override val threeDSRequestorPriorAuthenticationInfo: ThreeDSRequestorPriorTransactionAuthInfo?,
    override val threeDSServerOperatorID: String?,
    // v 2.2.0.0 fields
    override val whiteListStatus: TrustListStatus?,
    override val whiteListStatusSource: Source?,
    // v 2.3.0.0 fields
    override val acctType: String?,
    override val acctID: String?,
    override val dsReferenceNumber: String?,
    override val dsTransID: String,
    override val dsURL: String?,
    override val payTokenInd: Boolean?,
    override val messageExtension: MessageExtension?,
    override val purchaseInstalData: String?,
    //@Date
    override val recurringExpiry: String?,
    @Size(max = 4)
    override val recurringFrequency: String?,
    override val broadInfo: BroadCastInformation?,
    @Size(min = 3, max = 4) // Todo check with DS for validation
    override val cardSecurityCode: String?,
    override val cardSecurityCodeStatusSource: CardSecurityCodeStatusSource?,
    override val cardSecurityCodeStatus: CardSecurityCodeStatus?,
    override val deviceBindingStatus: DeviceBindingStatus?,
    override val deviceBindingStatusSource: Source?,
    override val payTokenInfo: PaymentTokenData?,
    override val multiTransaction: MultiTransaction?,
    @Size(max = 48)
    override val recurringAmount: Any?,
    override val recurringCurrency: Any?, // todo 4217
    @Pattern(regexp = "^\\d$")
    override val recurringExponent: Any?,
    //@Date
    override val recurringDate: Any?,
    override val recurringInd: RecurringIndicator?,
    override val sellerInfo: List<SellerInfo>?,
    @Size(max = 45)
    override val taxId: String?,
    override val trustListStatus: TrustListStatus?,
    override val trustListStatusSource: Source?,
    ): AuthenticationRequest()

data class AuthenticationRequestApp(
    val addrMatch: String?,
    val deviceRenderOptions: DeviceRenderOptions,
    val sdkAppID: String,
    val sdkMaxTimeout: String,
    val sdkEphemPubKey: SDKEphemeralPublicKey,
    val sdkReferenceNumber: String,
    val sdkTransID: String,
    val threeDSRequestorAuthenticationInd: String,
    val threeDSRequestorAuthenticationInfo: Unit?,
    val deviceInfo: Any, // todo create model
    val sdkServerSignedContent: String?,
    val sdkType: SDKType?,


)
data class AuthenticationRequest3RI(
    val threeRIInd: ThreeRIIndicator,
)

abstract class AuthenticationRequest{
    abstract val threeDSRequestorID: String
    abstract val threeDSRequestorName: String
    abstract val threeDSRequestorURL: String
    abstract val acquirerBIN: String?
    abstract val acquirerCountryCode: CountryCode
    abstract val acquirerCountryCodeSource: AcquirerCountryCodeSource
    abstract val acquirerMerchantID: String
    abstract val cardExpiryDate: String?
    abstract val acctNumber: String
    abstract val acctInfo: CardHolderAccountInformation?
    abstract val billAddrCity: String?
    abstract val billAddrCountry: String?
    abstract val billAddrLine1: String?
    abstract val billAddrLine2: String?
    abstract val billAddrLine3: String?
    abstract val billAddrPostCode: String?
    abstract val billAddrState: String?
    abstract val shipAddrCity: String?
    abstract val shipAddrCountry: String?
    abstract val shipAddrLine1: String?
    abstract val shipAddrLine2: String?
    abstract val shipAddrLine3: String?
    abstract val shipAddrPostCode: String?
    abstract val shipAddrState: String?
    abstract val email: String?
    abstract val homePhone: Phone?
    abstract val mobilePhone: Phone?
    abstract val cardholderName: String?
    abstract val workPhone: Phone?
    abstract val deviceChannel: String
    abstract val mcc: String?
    abstract val merchantCountryCode: String?
    abstract val merchantName: String?
    abstract val messageCategory: String
    abstract val messageType: MessageType
    abstract val messageVersion: String
    abstract val purchaseAmount: String?
    abstract val purchaseCurrency: String?
    abstract val purchaseExponent: String?
    abstract val purchaseDate: String?
    abstract val transType: String?
    abstract val threeDSServerURL: String
    abstract val threeDSServerTransID: String
    abstract val threeDSServerRefNumber: String
    abstract val threeDSReqAuthMethodInd: ThreeDSAuthenticationMethodVerificationIndicator?
    abstract val threeDSRequestorChallengeInd: ThreeDSRequestorChallengeIndicator?
    abstract val threeDSRequestorDecMaxTime: String?
    abstract val threeDSRequestorDecReqInd: ThreeDSRequestorDecoupledRequestIndicator?
    abstract val threeDSRequestorPriorAuthenticationInfo: ThreeDSRequestorPriorTransactionAuthInfo?
    abstract val threeDSServerOperatorID: String?
    // v 2.2.0.0 fields
    abstract val whiteListStatus: TrustListStatus?
    abstract val whiteListStatusSource: Source?
    // v 2.3.0.0 fields
    abstract val acctType: String?
    abstract val acctID: String?
    abstract val dsReferenceNumber: String?
    abstract val dsTransID: String
    abstract val dsURL: String?
    abstract val payTokenInd: Boolean?
    abstract val messageExtension: MessageExtension?
    abstract val purchaseInstalData: String?
    abstract val recurringExpiry: String?
    abstract val recurringFrequency: String?
    abstract val broadInfo: BroadCastInformation?
    abstract val cardSecurityCode: String?
    abstract val cardSecurityCodeStatusSource: CardSecurityCodeStatusSource?
    abstract val cardSecurityCodeStatus: CardSecurityCodeStatus?
    abstract val deviceBindingStatus: DeviceBindingStatus?
    abstract val deviceBindingStatusSource: Source?
    abstract val payTokenInfo: PaymentTokenData?
    abstract val multiTransaction: MultiTransaction?
    abstract val recurringAmount: Any?
    abstract val recurringCurrency: Any? // todo 4217
    abstract val recurringExponent: Any?
    abstract val recurringDate: Any?
    abstract val recurringInd: RecurringIndicator?
    abstract val sellerInfo: List<SellerInfo>?
    abstract val taxId: String?
    abstract val trustListStatus: TrustListStatus?
    abstract val trustListStatusSource: Source?
}



data class RecurringIndicator(
    val amountInd: AmountIndicator,
    val frequencyInd: FrequencyIndicator
)
enum class AmountIndicator(val indicator: String) {
    @JsonProperty("01") FIXED_PURCHASE_AMOUNT("01"),
    @JsonProperty("02") VARIABLE_PURCHASE_AMOUNT("02");

    companion object{

        private val errorDetail: String = "Value should be one of ${AmountIndicator.values().map { it -> it.indicator }.toString()}"
        private val enumMap: HashMap<String, AmountIndicator> = hashMapOf<String, AmountIndicator>();

        init {
            for (item in AmountIndicator.values()) {
                enumMap[item.indicator] = item
            }
        }
        @JsonCreator
        @JvmStatic
        fun from(value: String): AmountIndicator? {
            val indicatorValue: Int =
                value.toIntOrNull() ?: throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            if (indicatorValue in 3..79) throw ReservedRangeException(RESERVED_EMVCO, errorDetail)
            if (indicatorValue in 80..99) throw ReservedRangeException(RESERVED_DS, errorDetail)
            if (indicatorValue > 99) throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            return enumMap[value]
        }
    }
}


enum class FrequencyIndicator(val indicator: String) {
    @JsonProperty("01") FIXED_FREQUENCY("01"),
    @JsonProperty("02") VARIABLE_FREQUENCY("02");

    companion object{
        private val errorDetail: String = "Value should be one of ${FrequencyIndicator.values().map { it -> it.indicator }.toString()}"
        private val enumMap: HashMap<String, FrequencyIndicator> = hashMapOf<String, FrequencyIndicator>();

        init {
            for (item in FrequencyIndicator.values()) {
                enumMap[item.indicator] = item
            }
        }
        @JsonCreator
        @JvmStatic
        fun from(value: String): FrequencyIndicator? {
            val indicatorValue: Int =
                value.toIntOrNull() ?: throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            if (indicatorValue in 3..79) throw ReservedRangeException(RESERVED_EMVCO, errorDetail)
            if (indicatorValue in 80..99) throw ReservedRangeException(RESERVED_DS, errorDetail)
            if (indicatorValue > 99) throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            return enumMap[value]
        }
    }
}


enum class SPCIncompletionIndicator(val indicator: String) {
    @JsonProperty("01") INCOMPLETE("01"),
    @JsonProperty("02") CARD_HOLDER_CANCELS("02");

    companion object{
        private val errorDetail: String = "Value should be one of ${SPCIncompletionIndicator.values().map { it -> it.indicator }.toString()}"
        private val enumMap: HashMap<String, SPCIncompletionIndicator> = hashMapOf<String, SPCIncompletionIndicator>();

        init {
            for (item in SPCIncompletionIndicator.values()) {
                enumMap[item.indicator] = item
            }
        }
        @JsonCreator
        @JvmStatic
        fun from(value: String): SPCIncompletionIndicator? {
            val indicatorValue: Int =
                value.toIntOrNull() ?: throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            if (indicatorValue in 3..99) throw ReservedRangeException(RESERVED_EMVCO, errorDetail)
            if (indicatorValue > 99) throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            return enumMap[value]
        }
    }
}

data class SellerInfo(
    @Size(max = 100)
    val sellerName: String,
    @Size(max = 50)
    val sellerId: String?,
    @Size(max = 100)
    val sellerBusinessName: String?,
    //@Date
    val sellerAccDate: String?,
    @Size(max = 50)
    val sellerAddrLine1: String?,
    @Size(max = 50)
    val sellerAddrLine2: String?,
    @Size(max = 50)
    val sellerAddrLine3: String?,
    @Size(max = 50)
    val sellerAddrCity: String?,
    val sellerAddrState: Any?, // todo iso 3166 2
    @Size(max = 16)
    val sellerAddrPostCode: String?,
    val sellerAddrCountry: Any?, // todo iso 3166 1
    @Email
    val sellerEmail: String,
    val sellerPhone: Phone,

)
data class MultiTransaction(
    val merchantList: List<MerchantDetails>,
    @Pattern(regexp = "^([0-9]|[1-9][0-9])\$")
    val avValidityTime: String?,
    @Pattern(regexp = "^([0-9]|[1-9][0-9]|[1-9][0-9][0-9])\$")
    val avNumberUse: String?
)

data class MerchantDetails( // Todo class validation
    @Size(max = 40)
    val merchantNameListed: String,
    @Size(max = 15)
    val acquirerMerchantIdListed: String?,
    @Size(max = 48)
    val merchantAmount: String?,
    val merchantCurrency: Any?, //Todo currency codes
    val merchantExponent: String?,
    val sellerId: String?

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

        private val enumMap = hashMapOf<String, ThreeRIIndicator>();

        init {
            for (item in ThreeRIIndicator.values()) {
                enumMap[item.indicator] = item
            }
        }
        @JsonCreator
        @JvmStatic
        fun from(value: String): ThreeRIIndicator? {
            val indicatorValue: Int = value.toInt()
            if (indicatorValue in 15..79) throw Exception(RESERVED_EMVCO)
            if (indicatorValue in 80..99) throw Exception(RESERVED_DS)
            if (indicatorValue > 99) throw Exception(INVALID_VALUE)
            return enumMap[value]
        }
    }

}
enum class AcquirerCountryCodeSource(val source: String) {
    @JsonProperty("01") THREE_DS_SERVER("01"),
    @JsonProperty("02") DS("02");

    companion object{
        private val enumMap = hashMapOf<String, AcquirerCountryCodeSource>();
        private val errorDetail: String = "Value should be one of ${AcquirerCountryCodeSource.values().map { it -> it.source }.toString()}"

        init {
            for (item in AcquirerCountryCodeSource.values()) {
                enumMap[item.source] = item
            }
        }

        @JsonCreator
        @JvmStatic
        fun from(value: String): AcquirerCountryCodeSource? {
            val indicatorValue: Int =
                value.toIntOrNull() ?: throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
            if (indicatorValue in 3..79) throw ReservedRangeException(RESERVED_EMVCO, errorDetail)
            if (indicatorValue in 80..99) throw ReservedRangeException(RESERVED_DS, errorDetail)
            if (indicatorValue > 99) throw InvalidDataFormatException(INVALID_VALUE, errorDetail)
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

abstract class Sample {
    abstract val a: Date
}

data class Sample2 (
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyyMMdd")

    @get:PastOrPresent
    @JsonDeserialize(using = YYYYMMDD::class)
    override val a: Date,
    val b: String
    ): Sample()

