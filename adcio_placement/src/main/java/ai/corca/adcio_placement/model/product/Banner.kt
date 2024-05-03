package ai.corca.adcio_placement.model.product

data class Banner(
    val id: String,
    val clientId: String,
    val imageUrl: String,
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
