package ai.corca.adcio_analytics.network

internal object AnalyticsUrl {

    internal var baseUrl = "https://receiver-dev.adcio.ai/"

    private const val PERFORMANCE = "performance"

    object EndPoint {
        const val impression = "$PERFORMANCE/impression"
        const val click = "$PERFORMANCE/click"
        const val purchase = "$PERFORMANCE/purchase"
    }
}
