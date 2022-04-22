package one.upswing.acs.models

data class ResultRequest(
    val threeDSServerTransID: String,
    val acsTransID: String,
    val acsRenderingType: ACSRenderingType,
    val authenticationMethod: AuthenticationMethod,
    val authenticationValue: String,
    val broadInfo: BroadCastInformation,
    val cardholderInfo: CardHolderInfo,
    val challengeCancel: ChallengeCancellationIndicator,
    val challengeErrorReporting: ErrorMessage,
    val deviceBindingStatus: DeviceBindingStatus,
    val deviceBindingStatusSource: Source,
    val dsTransID: String,
    val eci: String,
    val interactionCounter: String,
    val messageExtension: MessageExtension,
    val messageType: MessageType,
    val messageVersion: String,
    val sdkTransID: String,
    val transStatus: TransactionStatus,
    val transStatusReason: TransactionStatusReason,
    val transStatusReasonInfo: String,
    val trustListStatus: TrustListStatus,
    val trustListStatusSource: Source
    )

