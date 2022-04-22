package one.upswing.acs.models

import com.fasterxml.jackson.databind.JsonNode

data class DeviceInformation(
    val DV: String,
    val DD: JsonNode
) {
}