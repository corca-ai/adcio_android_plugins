package ai.corca.adcio_analytics.network.data.event

import com.google.gson.annotations.SerializedName

data class AnalyticsPageViewRequest(
    @SerializedName("sessionId") val sessionId: String,
    @SerializedName("deviceId") val deviceId: String,
    @SerializedName("customerId") val customerId: String?,
    @SerializedName("storeId") val storeId: String,
    @SerializedName("productIdOnStore") val productIdOnStore: String?,
    @SerializedName("path") val path: String,
    @SerializedName("title") val title: String?,
    @SerializedName("referrer") val referrer: String?,
)
