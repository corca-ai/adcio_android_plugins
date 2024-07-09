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

    /**
     * This is a function that provides the same value as getSessionId in ADCIO Placement.
     */
    fun getSessionId(): String =
        SessionClient.loadSessionId()

    /**
     * This is a function that provides the same value as getDeviceId in ADCIO Placement.
     */
    fun getDeviceId(): String = loadDeviceId()

    /**
     * click event log
     * This event is called when a user clicks on a recommended product displayed on a suggestion placement.
     */
    fun onClick(
        option: AdcioLogOption,
        baseUrl: String? = null,
        customerId: String? = null,
        productIdOnStore: String? = null,
        storeId: String? = null,
        userAgent: String? = null,
    ) {
        analyticsRemote.onClick(
            sessionId = SessionClient.loadSessionId(),
            deviceId = loadDeviceId(),
            customerId = customerId,
            storeId = storeId ?: storeID,
            productIdOnStore = productIdOnStore,
            adcioLogOption = option,
            userAgent = userAgent,
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
        productIdOnStore: String? = null,
        baseUrl: String? = null,
        userAgent: String? = null,
    ) {
        analyticsRemote.onImpression(
            sessionId = SessionClient.loadSessionId(),
            deviceId = loadDeviceId(),
            customerId = customerId,
            storeId = storeId ?: storeID,
            adcioLogOption = option,
            productIdOnStore = productIdOnStore,
            userAgent = userAgent,
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
        option: AdcioLogOption? = null,
        categoryIdOnStore: String? = null,
        productIdOnStore: String? = null,
        quantity: Int? = null,
        amount: Int,
        userAgent: String? = null,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onPurchase(
            sessionId = SessionClient.loadSessionId(),
            deviceId = loadDeviceId(),
            customerId = customerId,
            orderId = orderId,
            storeId = storeId ?: storeID,
            requestId = option?.requestId,
            adsetId = option?.adsetId,
            categoryIdOnStore = categoryIdOnStore,
            productIdOnStore = productIdOnStore,
            quantity = quantity,
            amount = amount,
            userAgent = userAgent,
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
        option: AdcioLogOption? = null,
        categoryIdOnStore: String? = null,
        userAgent: String? = null,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onPageView(
            sessionId = SessionClient.loadSessionId(),
            deviceId = loadDeviceId(),
            customerId = customerId,
            storeId = storeId ?: storeID,
            requestId = option?.requestId,
            adsetId = option?.adsetId,
            productIdOnStore = productIdOnStore,
            categoryIdOnStore = categoryIdOnStore,
            userAgent = userAgent,
            baseUrl = baseUrl,
        )
    }

    fun onAddToCart(
        customerId: String? = null,
        storeId: String? = null,
        productIdOnStore: String? = null,
        categoryIdOnStore: String? = null,
        option: AdcioLogOption? = null,
        quantity: Int? = null,
        cartId: String? = null,
        userAgent: String? = null,
        baseUrl: String? = null,
    ) {
        analyticsRemote.onAddToCart(
            sessionId = SessionClient.loadSessionId(),
            deviceId = loadDeviceId(),
            customerId = customerId,
            storeId = storeId ?: storeID,
            productIdOnStore = productIdOnStore,
            categoryIdOnStore = categoryIdOnStore,
            cartId = cartId,
            requestId = option?.requestId,
            adsetId = option?.adsetId,
            quantity = quantity,
            userAgent = userAgent,
            baseUrl = baseUrl
        )
    }
}
