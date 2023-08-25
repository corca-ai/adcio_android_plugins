package ai.corca.adcio_placement.network.data

import com.google.gson.annotations.SerializedName

data class ProductData(
    @SerializedName("id") val id: String,
    @SerializedName("code") val code: String,
    @SerializedName("storeId") val storeId: String,
    @SerializedName("sellerId") val sellerId: String,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Int,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("includeInRecommendation") val includeInRecommendation: Boolean,
    @SerializedName("url") val url: String?,
    @SerializedName("deepLink") val deepLink: String?,
    @SerializedName("caption") val caption: String?,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String,
)
