package ai.corca.adcio_analytics.feature

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.network.remote.AnalyticsRemote

object AdcioAnalytics {

    private val analyticsRemote: AnalyticsRemote = AnalyticsRemote()

    /**
     * click event log
     * This event is called when a user clicks on a recommended product displayed on a suggestion placement.
     */
    fun onClick(
        requestId: String,
        adsetId: String,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onClick(
            adcioLogOption = AdcioLogOption(
                requestId = requestId,
                adsetId = adsetId,
            ),
            baseUrl = baseUrl,
        )
    }

    /**
     * impression event log
     * This event is called when a suggestion placement is displayed on the screen during the ad lifecycle (e.g., page lifecycle). This call occurs only once when the suggestion placement is revealed.
     */
    fun onImpression(
        requestId: String,
        adsetId: String,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onImpression(
            adcioLogOption = AdcioLogOption(
                requestId = requestId,
                adsetId = adsetId,
            ),
            baseUrl = baseUrl,
        )
    }

    /**
     * purchase event log
     * This event is called when a user purchases a recommended product.
     */
    fun onPurchase(
        requestId: String,
        adsetId: String,
        amount: Int,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onPurchase(
            adcioLogOption = AdcioLogOption(
                requestId = requestId,
                adsetId = adsetId,
            ),
            amount = amount,
            baseUrl = baseUrl,
        )
    }
}
