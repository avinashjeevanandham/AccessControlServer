package one.upswing.acs.model

data class MessageExtension(val messageExtension: List<MessageExtensionData>) {
}

data class MessageExtensionData(
    val name: String,
    val id: String,
    val criticalityIndicator: Boolean,
    val data: Any
    ){}