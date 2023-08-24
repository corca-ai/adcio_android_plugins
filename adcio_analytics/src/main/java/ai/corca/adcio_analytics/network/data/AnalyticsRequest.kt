package ai.corca.adcio_analytics.network.data

import com.google.gson.annotations.SerializedName

data class AnalyticsRequest(
    @SerializedName("requestId") val requestId: String,
    @SerializedName("adsetId") val adsetId: String,
    @SerializedName("amount") val amount: Int? = null,
) {
    override fun toString(): String {
        return "AnalyticsRequest(requestId: $requestId, adsetId: $adsetId, amount: $amount)"
    }
}
