package ai.corca.adcio_analytics.feature

import ai.corca.adcio_analytics.exception.NotInitializedException
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.network.remote.AnalyticsRemote
import android.util.Log

object AdcioAnalytics {

    private var isInitialized: Boolean = false

    private val analyticsRemote: AnalyticsRemote = AnalyticsRemote()
    lateinit var adcioAnalyticsHistory: AdcioAnalyticsHistory

    fun initAnalytics(adcioAnalyticsHistory: AdcioAnalyticsHistory) {
        isInitialized = true
        Log.d("TestTestTest", "in Analytics: ${adcioAnalyticsHistory.hashCode()}")
        this.adcioAnalyticsHistory = adcioAnalyticsHistory
    }

    /**
     * click event log
     * This event is called when a user clicks on a recommended product displayed on a suggestion placement.
     */
    fun onClick(
        requestId: String,
        adsetId: String,
        baseUrl: String? = null,
    ) {
        if (!isInitialized) throw NotInitializedException()

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
        if (!isInitialized) throw NotInitializedException()

        if (adcioAnalyticsHistory.addImpressionHistory(adsetId)) {
            // true일 경우 값 저장이 되었다는 것. -> 첫 노출.
            analyticsRemote.onImpression(
                adcioLogOption = AdcioLogOption(
                    requestId = requestId,
                    adsetId = adsetId,
                ),
                baseUrl = baseUrl,
            )
        }
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
        if (!isInitialized) throw NotInitializedException()

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
