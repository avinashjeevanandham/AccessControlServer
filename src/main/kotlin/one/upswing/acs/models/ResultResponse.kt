package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ResultResponse(
    val threeDSServerTransID: String,
    val acsTransID: String,
    val dsTransID: String,
    val messageExtension: MessageExtension,
    val messageType: MessageType,
    val messageVersion: String,
    val resultsStatus: ResultsMessageStatus,
    val sdkTransID: String
    )

enum class ResultsMessageStatus(val status: String) {
    @JsonProperty("01") RREQ_RECEIVED_FOR_FURTHER_PROCESSING("01"),
    @JsonProperty("02") CREQ_NOT_SENT_TO_ACS("02"),
    @JsonProperty("03") ARES_NOT_DELIVERED_TO_THE_3DS_REQUESTOR("03")
}