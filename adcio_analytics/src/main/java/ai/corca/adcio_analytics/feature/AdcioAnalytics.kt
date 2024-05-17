package ai.corca.adcio_analytics.feature

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.network.remote.AnalyticsRemote
import com.corcaai.core.ids.SessionClient
import com.corcaai.core.ids.loadDeviceId

class AdcioAnalytics(
    private val clientId: String
) {

    private val storeID: String by lazy {
        clientId.ifEmpty {
            throw IllegalArgumentException("clientId cannot be empty")
        }
    }
    
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
        customerId: String? = null,
        storeId: String? = null,
    ) {
        analyticsRemote.onClick(
            sessionId = SessionClient.loadSessionId(),
            deviceId = loadDeviceId(),
            customerId = customerId,
            storeId = storeId ?: storeID,
            adcioLogOption = option,
            baseUrl = baseUrl,
        )
    }

    /**
     * impression event log
     * This event is called when a suggestion placement is displayed on the screen during the ad lifecycle (e.g., page lifecycle). This call occurs only once when the suggestion placement is revealed.
     */
    fun onImpression(
        customerId: String? = null,
        storeId: String? = null,
        option: AdcioLogOption,
        baseUrl: String? = null,
    ) {
        impressionHistory.add(option.adsetId)

        analyticsRemote.onImpression(
            sessionId = SessionClient.loadSessionId(),
            deviceId = loadDeviceId(),
            customerId = customerId,
            storeId = storeId ?: storeID,
            adcioLogOption = option,
            baseUrl = baseUrl,
        )
    }

    /**
     * purchase event log
     * This event is called when a user purchases a recommended product.
     */
    fun onPurchase(
        customerId: String? = null,
        orderId: String,
        storeId: String? = null,
        productIdOnStore: String,
        amount: Int,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onPurchase(
            sessionId = SessionClient.loadSessionId(),
            deviceId = loadDeviceId(),
            customerId = customerId,
            orderId = orderId,
            storeId = storeId ?: storeID,
            productIdOnStore = productIdOnStore,
            amount = amount,
            baseUrl = baseUrl,
        )
    }

    /**
     * pageView event log
     * Log when the customer views a specific product / category page.
     * If this is a specific product/category page, please add your productId to the productIdOnStore parameter.
     */
    fun onPageView(
        productIdOnStore: String,
        customerId: String? = null,
        storeId: String? = null,
        title: String? = null,
        referrer: String? = null,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onPageView(
            sessionId = SessionClient.loadSessionId(),
            deviceId = loadDeviceId(),
            customerId = customerId,
            storeId = storeId ?: storeID,
            productIdOnStore = productIdOnStore,
            title = title,
            referrer = referrer,
            baseUrl = baseUrl,
        )
    }

    fun onAddToCart(
        customerId: String? = null,
        storeId: String? = null,
        productIdOnStore: String,
        cartId: String,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onAddToCart(
            sessionId = SessionClient.loadSessionId(),
            deviceId = loadDeviceId(),
            customerId = customerId,
            storeId = storeId ?: storeID,
            productIdOnStore = productIdOnStore,
            cartId = cartId,
            baseUrl = baseUrl
        )
    }
}
