package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class OperationRequest(
    val dsReferenceNumber: String,
    val dsTransID: String,
    val messageExtension: MessageExtension,
    val messageType: MessageType,
    val messageVersion: String,
    val opCategory: OperationCategory,
    val opDescription: String,
    val opExpDate: String,
    val opPriorTransRef: OperationPriorTransactionReference,
    val opSeverity: Severity,
    val opSeq: OperationSequence
)

data class OperationSequence(
    val seqId: String,
    val seqNum: String,
    val seqTotal: String
)
data class OperationPriorTransactionReference(
    val transIdType: Source,
    val transId: String
)
enum class OperationCategory (val category: String) {
    @JsonProperty("01") GENERAL("01"),
    @JsonProperty("02") OPERATIONAL_ALERT("02"),
    @JsonProperty("03") PUBLIC_KEY_CERT_EXPIRY("03"),
    @JsonProperty("04") LOA_OR_AOC_EXPIRY("04"),
    @JsonProperty("05") FRAUD("05"),
    @JsonProperty("06") OTHER("06"),
}