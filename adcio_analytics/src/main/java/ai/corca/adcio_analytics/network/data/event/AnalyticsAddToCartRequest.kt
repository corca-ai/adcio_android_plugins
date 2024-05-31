package ai.corca.adcio_analytics.network.data.event

import com.google.gson.annotations.SerializedName

data class AnalyticsAddToCartRequest(
    @SerializedName("sessionId") val sessionId: String,
    @SerializedName("deviceId") val deviceId: String,
    @SerializedName("customerId") val customerId: String?,
    @SerializedName("cartId") val cartId: String?,
    @SerializedName("storeId") val storeId: String,
    @SerializedName("productIdOnStore") val productIdOnStore: String,
)
