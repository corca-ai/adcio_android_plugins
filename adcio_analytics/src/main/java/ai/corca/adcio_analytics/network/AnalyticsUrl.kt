package ai.corca.adcio_analytics.network

internal object AnalyticsUrl {

    internal var baseUrl = "https://receiver.adcio.ai/"

    private const val PERFORMANCE = "performance"
    private const val EVENTS = "events"
    object EndPoint {
        const val impression = "$EVENTS/impression"
        const val click = "$EVENTS/click"
        const val purchase = "$EVENTS/purchase"
        const val pageView = "$EVENTS/view"
        const val addToCart = "$EVENTS/add-to-cart"
    }
}
