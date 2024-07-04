package ai.corca.adcio_analytics

data class AdcioLogOption(
    // suggestion identifier
    val requestId: String,
    // advertisement identifier
    val adsetId: String,
) {

    override fun toString(): String {
        return "AnalyticsRequest(requestId: $requestId, adsetId: $adsetId)"
    }
}
