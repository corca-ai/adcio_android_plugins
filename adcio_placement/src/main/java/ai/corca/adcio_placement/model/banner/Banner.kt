package ai.corca.adcio_placement.model.banner

data class Banner(
    val id: String,
    val clientId: String,
    val creative: Creative,
    val url: String,
    val name: String,
    val categoryId: String?,
    val productId: String?,
    val activated: Boolean,
    val startsAt: String,
    val endsAt: String?,
    val createdAt: String,
    val deletedAt: String?,
)

data class Creative(
    val mediaUrl: String,
)
