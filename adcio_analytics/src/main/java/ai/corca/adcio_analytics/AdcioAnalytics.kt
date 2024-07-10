package ai.corca.adcio_analytics

import ai.corca.generator_analytics.model.TrackAddToCartRequestDto
import ai.corca.generator_analytics.model.TrackClickRequestDto
import ai.corca.generator_analytics.model.TrackImpressionRequestDto
import ai.corca.generator_analytics.model.TrackPageViewRequestDto
import ai.corca.generator_analytics.model.TrackPurchaseRequestDto
import android.os.Build
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
        userAgent: String? = null
    ) {
        eventsApi.eventsControllerOnClick(
            trackClickRequestDto = TrackClickRequestDto(
                storeId = storeID,
                deviceId = loadDeviceId(),
                sessionId = SessionClient.loadSessionId(),
                customerId = customerId,
                productIdOnStore = productIdOnStore,
                sdkVersion = sdkVersion,
                adsetId = option.adsetId,
                requestId = option.requestId,
                userAgent = userAgent ?: "${Build.MODEL}-${Build.VERSION.RELEASE}"
            )
        )
    }

    /**
     * impression event log
     * This event is called when a suggestion placement is displayed on the screen during the ad lifecycle (e.g., page lifecycle). This call occurs only once when the suggestion placement is revealed.
     */
    suspend fun onImpression(
        customerId: String? = null,
        option: AdcioLogOption,
        productIdOnStore: String? = null,
        userAgent: String? = null
    ) {
        eventsApi.eventsControllerOnImpression(
            trackImpressionRequestDto = TrackImpressionRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                customerId = customerId,
                storeId = storeID,
                sdkVersion = sdkVersion,
                productIdOnStore = productIdOnStore,
                adsetId = option.adsetId,
                requestId = option.requestId,
                userAgent = userAgent ?: "${Build.MODEL}-${Build.VERSION.RELEASE}"
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
        userAgent: String? = null,
    ) {
        eventsApi.eventsControllerOnPurchase(
            trackPurchaseRequestDto = TrackPurchaseRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                customerId = customerId,
                orderId = orderId,
                storeId = storeID,
                sdkVersion = sdkVersion,
                requestId = option?.requestId,
                adsetId = option?.adsetId,
                categoryIdOnStore = categoryIdOnStore,
                productIdOnStore = productIdOnStore,
                quantity = quantity?.toBigDecimal(),
                amount = amount.toBigDecimal(),
                userAgent = userAgent ?: "${Build.MODEL}-${Build.VERSION.RELEASE}"
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
        userAgent: String? = null,
    ) {
        eventsApi.eventsControllerOnPageView(
            trackPageViewRequestDto = TrackPageViewRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                customerId = customerId,
                storeId = storeID,
                requestId = option?.requestId,
                adsetId = option?.adsetId,
                sdkVersion = sdkVersion,
                productIdOnStore = productIdOnStore,
                categoryIdOnStore = categoryIdOnStore,
                userAgent = userAgent ?: "${Build.MODEL}-${Build.VERSION.RELEASE}"
            )
        )
    }

    suspend fun onAddToCart(
        customerId: String? = null,
        productIdOnStore: String,
        categoryIdOnStore: String? = null,
        option: AdcioLogOption? = null,
        quantity: Int? = null,
        cartId: String? = null,
        userAgent: String? = null,
    ) {
        eventsApi.eventsControllerOnAddToCart(
            trackAddToCartRequestDto = TrackAddToCartRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                customerId = customerId,
                storeId = storeID,
                productIdOnStore = productIdOnStore,
                categoryIdOnStore = categoryIdOnStore,
                cartId = cartId,
                sdkVersion = sdkVersion,
                requestId = option?.requestId,
                adsetId = option?.adsetId,
                quantity = quantity?.toBigDecimal(),
                userAgent = userAgent ?: "${Build.MODEL}-${Build.VERSION.RELEASE}"
            )
        )
    }
}