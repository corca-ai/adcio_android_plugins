package ai.corca.adcio_analytics.feature

import ai.corca.adcio_analytics.eventsApi
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.model.TrackAddToCartRequestDto
import ai.corca.adcio_analytics.model.TrackClickRequestDto
import ai.corca.adcio_analytics.model.TrackImpressionRequestDto
import ai.corca.adcio_analytics.model.TrackPageViewRequestDto
import ai.corca.adcio_analytics.model.TrackPurchaseRequestDto
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
    suspend fun onClick(
        option: AdcioLogOption,
        customerId: String? = null,
        productIdOnStore: String? = null,
    ) {
        eventsApi.eventsControllerOnClick(
            trackClickRequestDto = TrackClickRequestDto(
                storeId = clientId,
                deviceId = getDeviceId(),
                sessionId = SessionClient.loadSessionId(),
                customerId = customerId,
                productIdOnStore = productIdOnStore,
                adsetId = option.adsetId,
                requestId = option.requestId
            )
        )
    }

    /**
     * impression event log
     * This event is called when a suggestion placement is displayed on the screen during the ad lifecycle (e.g., page lifecycle). This call occurs only once when the suggestion placement is revealed.
     */
    suspend fun onImpression(
        customerId: String? = null,
        storeId: String? = null,
        option: AdcioLogOption,
        productIdOnStore: String? = null,
    ) {
        eventsApi.eventsControllerOnImpression(
            trackImpressionRequestDto = TrackImpressionRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                customerId = customerId,
                storeId = storeId ?: storeID,
                productIdOnStore = productIdOnStore,
                adsetId = option.adsetId,
                requestId = option.requestId
            )
        )
    }

    /**
     * purchase event log
     * This event is called when a user purchases a recommended product.
     */
    suspend fun onPurchase(
        customerId: String? = null,
        orderId: String,
        option: AdcioLogOption? = null,
        categoryIdOnStore: String? = null,
        productIdOnStore: String? = null,
        quantity: Int? = null,
        amount: Int,
    ) {
        eventsApi.eventsControllerOnPurchase(
            trackPurchaseRequestDto = TrackPurchaseRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                customerId = customerId,
                orderId = orderId,
                storeId = clientId,
                requestId = option?.requestId,
                adsetId = option?.adsetId,
                categoryIdOnStore = categoryIdOnStore,
                productIdOnStore = productIdOnStore,
                quantity = quantity?.toBigDecimal(),
                amount = amount.toBigDecimal(),
            )
        )
    }

    /**
     * pageView event log
     * Log when the customer views a specific product / category page.
     * If this is a specific product/category page, please add your productId to the productIdOnStore parameter.
     */
    suspend fun onPageView(
        productIdOnStore: String,
        customerId: String? = null,
        option: AdcioLogOption? = null,
        categoryIdOnStore: String? = null,
    ) {
        eventsApi.eventsControllerOnPageView(
            trackPageViewRequestDto = TrackPageViewRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                customerId = customerId,
                storeId = clientId,
                requestId = option?.requestId,
                adsetId = option?.adsetId,
                productIdOnStore = productIdOnStore,
                categoryIdOnStore = categoryIdOnStore,
            )
        )
    }

    suspend fun onAddToCart(
        customerId: String? = null,
        storeId: String? = null,
        productIdOnStore: String? = null,
        categoryIdOnStore: String? = null,
        option: AdcioLogOption? = null,
        quantity: Int? = null,
        cartId: String? = null,
    ) {
        eventsApi.eventsControllerOnAddToCart(
            trackAddToCartRequestDto = TrackAddToCartRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                customerId = customerId,
                storeId = storeId ?: storeID,
                productIdOnStore = productIdOnStore,
                categoryIdOnStore = categoryIdOnStore,
                cartId = cartId,
                requestId = option?.requestId,
                adsetId = option?.adsetId,
                quantity = quantity?.toBigDecimal(),
            )
        )
    }
}
