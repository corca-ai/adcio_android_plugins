package ai.corca.adcio_analytics.network.data.event

import com.google.gson.annotations.SerializedName

data class AnalyticsPurchaseRequest(
    @SerializedName("sessionId") val sessionId: String,
    @SerializedName("deviceId") val deviceId: String,
    @SerializedName("customerId") val customerId: String?,
    @SerializedName("orderId") val orderId: String,
    @SerializedName("storeId") val storeId: String,
    @SerializedName("productIdOnStore") val productIdOnStore: String,
    @SerializedName("amount") val amount: Int,
)
