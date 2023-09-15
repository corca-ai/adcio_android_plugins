package ai.corca.adcio_analytics.feature

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.model.AnalyticsPageViewOption
import ai.corca.adcio_analytics.network.remote.AnalyticsRemote

object AdcioAnalytics {

    private val analyticsRemote: AnalyticsRemote = AnalyticsRemote()

    private val impressionHistory: MutableSet<String> = mutableSetOf()

    internal fun hasImpression(adsetId: String): Boolean = impressionHistory.contains(adsetId)

    /**
     * [Warning] Do not call this event. This event is only used internally in 'adcio_placement'. If called, the necessary logs for analysis may not be collected correctly.
     */
    fun clearImpressionHistory() = impressionHistory.clear()

    /**
     * click event log
     * This event is called when a user clicks on a recommended product displayed on a suggestion placement.
     */
    fun onClick(
        option: AdcioLogOption,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onClick(
            adcioLogOption = option,
            baseUrl = baseUrl,
        )
    }

    /**
     * impression event log
     * This event is called when a suggestion placement is displayed on the screen during the ad lifecycle (e.g., page lifecycle). This call occurs only once when the suggestion placement is revealed.
     */
    fun onImpression(
        option: AdcioLogOption,
        baseUrl: String? = null,
    ) {
        impressionHistory.add(option.adsetId)

        analyticsRemote.onImpression(
            adcioLogOption = option,
            baseUrl = baseUrl,
        )
    }

    /**
     * purchase event log
     * This event is called when a user purchases a recommended product.
     */
    fun onPurchase(
        option: AdcioLogOption,
        amount: Int,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onPurchase(
            adcioLogOption = option,
            amount = amount,
            baseUrl = baseUrl,
        )
    }

    /**
     * pageView event log
     * This event is called when a new screen is shown to the user.
     */
    fun onPageView(
        pageViewOption: AnalyticsPageViewOption,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onPageView(
            pageViewOption = pageViewOption,
            baseUrl = baseUrl,
        )
    }
}
