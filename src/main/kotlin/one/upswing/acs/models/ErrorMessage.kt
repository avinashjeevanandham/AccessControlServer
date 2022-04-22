package one.upswing.acs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorMessage(
    val threeDSServerTransID: String,
    val acsTransID: String,
    val dsTransID: String,
    val errorCode: ErrorCodes,
    val errorComponent: ErrorComponent,
    val errorDescription: String,
    val errorDetail: String,
    val errorMessageType: MessageType,
    val messageType: MessageType,
    val messageVersion: String,
    val sdkTransID: String
)

enum class ErrorComponent(val info: String){
    @JsonProperty("C") THREE_DS_SDK("C"),
    @JsonProperty("S") THREE_DS_SERVER("S"),
    @JsonProperty("D") DS("D"),
    @JsonProperty("A") ACS("A")
}

enum class ErrorCodes(val code: String) {
    @JsonProperty("101") MESSAGE_RECEIVED_INVALID("101"),
    @JsonProperty("102") MESSAGE_VERSION_NUMBER_NOT_SUPPORTED("102"),
    @JsonProperty("201") REQUIRED_DATA_ELEMENT_MISSING("201"),
    @JsonProperty("202") CRITICAL_MESSAGE_EXTENSION_NOT_RECOGNISED("202"),
    @JsonProperty("204") DUPLICATE_DATA_ELEMENT("203"),
    @JsonProperty("207") VALUE_IN_THE_RESERVED_RANGE("207"),
    @JsonProperty("301") TRANSACTION_ID_NOT_RECOGNISED("301"),
    @JsonProperty("302") DATA_DECRYPTION_FAILURE("302"),
    @JsonProperty("303") ACCESS_DENIED_OR_INVALID_END_POINT("303"),
    @JsonProperty("304") ISO_CODE_INVALID("304"),
    @JsonProperty("305") TRANSACTION_DATA_NOT_VALID("305"),
    @JsonProperty("309") CONTENT_SECURITY_POLICY_VALIDATION_FAILURE("309"),
    @JsonProperty("310") INCORRECT_CRYPTOGRAPHIC_ALGORITHM("310"),
    @JsonProperty("312") DUPLICATE_MESSAGE("312"),
    @JsonProperty("313") INCONSISTENT_RREQ_MESSAGE("313"),
    @JsonProperty("314") MULTIPLE_CREQ_NOT_SUPPORTED("314"),
    @JsonProperty("315") CREQ_RECEIVED_AFTER_RREQ("315"),
    @JsonProperty("402") TRANSACTION_TIMED_OUT("402"),
    @JsonProperty("403") TRANSIENT_SYSTEM_FAILURE("403"),
    @JsonProperty("404") PERMANENT_SYSTEM_FAILURE("404"),
    @JsonProperty("405") SYSTEM_CONNECTION_FAILURE("405")
}