package ai.corca.adcio_analytics.network.data

import com.google.gson.annotations.SerializedName

data class AnalyticsPerformanceRequest(
    @SerializedName("requestId") val requestId: String,
    @SerializedName("adsetId") val adsetId: String,
) {
    override fun toString(): String {
        return "AnalyticsRequest(requestId: $requestId, adsetId: $adsetId)"
    }
}
