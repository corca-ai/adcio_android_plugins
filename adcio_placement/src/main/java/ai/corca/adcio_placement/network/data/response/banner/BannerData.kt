package ai.corca.adcio_placement.network.data.response.banner

import com.google.gson.annotations.SerializedName

data class BannerData(
    @SerializedName("id") val id: String,
    @SerializedName("clientId") val clientId: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("url") val url: String,
    @SerializedName("name") val name: String,
    @SerializedName("categoryId") val categoryId: String?,
    @SerializedName("productId") val productId: String?,
    @SerializedName("activated") val activated: Boolean,
    @SerializedName("startsAt") val startsAt: String,
    @SerializedName("endsAt") val endsAt: String?,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("deletedAt") val deletedAt: String?,
)
