package one.upswing.acs.models

abstract class ResultRequest{
    abstract val threeDSServerTransID: String
    abstract val acsTransID: String
    abstract val authenticationMethod: AuthenticationMethod?
    abstract val authenticationValue: String?
    abstract val cardholderInfo: CardHolderInfo?
    abstract val challengeCancel: ChallengeCancellationIndicator?
    abstract val deviceBindingStatus: DeviceBindingStatus?
    abstract val deviceBindingStatusSource: Source?
    abstract val dsTransID: String
    abstract val eci: String
    abstract val interactionCounter: String?
    abstract val messageExtension: MessageExtension?
    abstract val messageType: MessageType
    abstract val messageVersion: String
    abstract val transStatus: TransactionStatus?
    abstract val transStatusReason: TransactionStatusReason?
    abstract val transStatusReasonInfo: String?
    abstract val trustListStatus: TrustListStatus?
    abstract val trustListStatusSource: Source?
}

data class ResultRequestApp(
    val acsRenderingType: ACSRenderingType?, // app
    val challengeErrorReporting: ErrorMessage?,
    val sdkTransID: String,
    override val threeDSServerTransID: String,
    override val acsTransID: String,
    override val authenticationMethod: AuthenticationMethod?,
    override val authenticationValue: String?,
    override val cardholderInfo: CardHolderInfo?,
    override val challengeCancel: ChallengeCancellationIndicator?,
    override val deviceBindingStatus: DeviceBindingStatus?,
    override val deviceBindingStatusSource: Source?,
    override val dsTransID: String,
    override val eci: String,
    override val interactionCounter: String?,
    override val messageExtension: MessageExtension?,
    override val messageType: MessageType,
    override val messageVersion: String,
    override val transStatus: TransactionStatus?,
    override val transStatusReason: TransactionStatusReason?,
    override val transStatusReasonInfo: String?,
    override val trustListStatus: TrustListStatus?,
    override val trustListStatusSource: Source?
    ) : ResultRequest()

data class ResultRequestBrowser(
    val challengeErrorReporting: ErrorMessage?,
    override val threeDSServerTransID: String,
    override val acsTransID: String,
    override val authenticationMethod: AuthenticationMethod?,
    override val authenticationValue: String?,
    override val cardholderInfo: CardHolderInfo?,
    override val challengeCancel: ChallengeCancellationIndicator?,
    override val deviceBindingStatus: DeviceBindingStatus?,
    override val deviceBindingStatusSource: Source?,
    override val dsTransID: String,
    override val eci: String,
    override val interactionCounter: String?,
    override val messageExtension: MessageExtension?,
    override val messageType: MessageType,
    override val messageVersion: String,
    override val transStatus: TransactionStatus?,
    override val transStatusReason: TransactionStatusReason?,
    override val transStatusReasonInfo: String?,
    override val trustListStatus: TrustListStatus?,
    override val trustListStatusSource: Source?
): ResultRequest()

data class ResultRequest3RI(
    override val threeDSServerTransID: String,
    override val acsTransID: String,
    override val authenticationMethod: AuthenticationMethod?,
    override val authenticationValue: String?,
    override val cardholderInfo: CardHolderInfo?,
    override val challengeCancel: ChallengeCancellationIndicator?,
    override val deviceBindingStatus: DeviceBindingStatus?,
    override val deviceBindingStatusSource: Source?,
    override val dsTransID: String,
    override val eci: String,
    override val interactionCounter: String?,
    override val messageExtension: MessageExtension?,
    override val messageType: MessageType,
    override val messageVersion: String,
    override val transStatus: TransactionStatus?,
    override val transStatusReason: TransactionStatusReason?,
    override val transStatusReasonInfo: String?,
    override val trustListStatus: TrustListStatus?,
    override val trustListStatusSource: Source?
): ResultRequest()
