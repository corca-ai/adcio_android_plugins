package ai.corca.adcio_placement.model.product

data class Product(
    val id: String,
    val idOnStore: String,
    val storeId: String,
    val sellerId: String,
    val name: String,
    val price: Int,
    val description: String?,
    val image: String,
    val includeInRecommendation: Boolean,
    val url: String?,
    val deepLink: String?,
    val caption: String?,
    val createdAt: String,
    val updatedAt: String,
)
