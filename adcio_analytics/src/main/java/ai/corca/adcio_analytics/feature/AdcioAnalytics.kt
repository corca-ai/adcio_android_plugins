package ai.corca.adcio_analytics.feature

import ai.corca.adcio_analytics.exception.NotInitializedException
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.network.remote.AnalyticsRemote

object AdcioAnalytics {

    private var isInitialized: Boolean = false

    private val analyticsRemote: AnalyticsRemote = AnalyticsRemote()
    lateinit var adcioAnalyticsHistory: AdcioAnalyticsHistory

    /**
     * call this function first! - init analytics function.
     * If you do not call initAnalytics, NotInitializedException will be thrown.
     */
    fun initAnalytics(adcioAnalyticsHistory: AdcioAnalyticsHistory) {
        isInitialized = true
        this.adcioAnalyticsHistory = adcioAnalyticsHistory
    }

    /**
     * click event log
     * This event is called when a user clicks on a recommended product displayed on a suggestion placement.
     */
    fun onClick(
        option: AdcioLogOption,
        baseUrl: String? = null,
    ) {
        if (!isInitialized) throw NotInitializedException()

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
        if (!isInitialized) throw NotInitializedException()

        if (adcioAnalyticsHistory.addImpressionHistory(option.adsetId)) {
            analyticsRemote.onImpression(
                adcioLogOption = option,
                baseUrl = baseUrl,
            )
        }
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
        if (!isInitialized) throw NotInitializedException()

        analyticsRemote.onPurchase(
            adcioLogOption = option,
            amount = amount,
            baseUrl = baseUrl,
        )
    }
}
