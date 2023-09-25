package ai.corca.adcio_analytics.feature

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.network.remote.AnalyticsRemote
import com.corcaai.adcio_core.feature.AdcioCore

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
        sessionId: String? = null,
        deviceId: String? = null,
        customerId: String? = null,
        orderId: String,
        storeId: String? = null,
        productIdOnStore: String,
        amount: Int,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onPurchase(
            sessionId = sessionId ?: AdcioCore.sessionId,
            deviceId = deviceId ?: AdcioCore.deviceId,
            customerId = customerId,
            orderId = orderId,
            storeId = storeId ?: AdcioCore.storeId,
            productIdOnStore = productIdOnStore,
            amount = amount,
            baseUrl = baseUrl,
        )
    }

    /**
     * pageView event log
     * This event is called when a new screen is shown to the user.
     */
    fun onPageView(
        path: String,
        sessionId: String? = null,
        deviceId: String? = null,
        customerId: String? = null,
        storeId: String? = null,
        productIdOnStore: String? = null,
        title: String? = null,
        referrer: String? = null,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onPageView(
            path = path,
            sessionId = sessionId ?: AdcioCore.sessionId,
            deviceId = deviceId ?: AdcioCore.deviceId,
            customerId = customerId,
            storeId = storeId ?: AdcioCore.storeId,
            productIdOnStore = productIdOnStore,
            title = title ?: path,
            referrer = referrer,
            baseUrl = baseUrl,
        )
    }

    fun onAddToCart(
        sessionId: String? = null,
        deviceId: String? = null,
        customerId: String? = null,
        storeId: String? = null,
        productIdOnStore: String,
        cartId: String,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onAddToCart(
            sessionId = sessionId ?: AdcioCore.sessionId,
            deviceId = deviceId ?: AdcioCore.deviceId,
            customerId = customerId,
            storeId = storeId ?: AdcioCore.storeId,
            productIdOnStore = productIdOnStore,
            cartId = cartId,
            baseUrl = baseUrl
        )
    }
}
