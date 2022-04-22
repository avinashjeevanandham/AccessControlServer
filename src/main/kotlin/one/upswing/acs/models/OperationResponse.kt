package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class OperationResponse(
    val acsReferenceNumber: String,
    val acsTransID: String,
    val dsTransID: String,
    val messageExtension: MessageExtension,
    val messageType: MessageType,
    val opStatus: OperationMessageStatus
)

enum class OperationMessageStatus(val status: String){
    @JsonProperty("01") SUCCESSFULLY_RECEIVED_MESSAGES("01"),
    @JsonProperty("02") MESSAGE_SEQUENCE_IS_BROKEN("02"),
    @JsonProperty("03") ACTION_NOT_SUPPORTED("03")
}