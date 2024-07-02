package ai.corca.adcio_analytics.network.remote

import ai.corca.adcio_analytics.exception.PlatformException
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.network.RetrofitClient
import ai.corca.adcio_analytics.network.data.AnalyticsPerformanceRequest
import ai.corca.adcio_analytics.network.data.event.AnalyticsAddToCartRequest
import ai.corca.adcio_analytics.network.data.event.AnalyticsPageViewRequest
import ai.corca.adcio_analytics.network.data.event.AnalyticsPurchaseRequest
import ai.corca.adcio_analytics.network.data.toException
import ai.corca.adcio_analytics.utils.TRACE_EXCEPTION_TAG
import ai.corca.adcio_analytics.utils.toNetworkErrorLog
import android.util.Log
import retrofit2.Response

internal class AnalyticsRemote {

    private val networkSuccessRange = 200 until 300

    fun onImpression(
        sessionId: String,
        deviceId: String,
        customerId: String?,
        storeId: String,
        adcioLogOption: AdcioLogOption,
        productIdOnStore: String?,
        baseUrl: String?,
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        val response = service.onImpression(
            analyticsPerformanceRequest = AnalyticsPerformanceRequest(
                sessionId = sessionId,
                deviceId = deviceId,
                customerId = customerId,
                storeId = storeId,
                productIdOnStore = productIdOnStore,
                requestId = adcioLogOption.requestId,
                adsetId = adcioLogOption.adsetId
            )
        ).execute()

        checkError(response)?.let { throw it }
    }

    fun onClick(
        sessionId: String,
        deviceId: String,
        customerId: String?,
        storeId: String,
        adcioLogOption: AdcioLogOption,
        productIdOnStore: String?,
        baseUrl: String?,
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        val response = service.onClick(
            analyticsPerformanceRequest = AnalyticsPerformanceRequest(
                sessionId = sessionId,
                deviceId = deviceId,
                customerId = customerId,
                storeId = storeId,
                productIdOnStore = productIdOnStore,
                requestId = adcioLogOption.requestId,
                adsetId = adcioLogOption.adsetId,
            )
        ).execute()

        checkError(response)?.let { throw it }
    }

    fun onPurchase(
        sessionId: String,
        deviceId: String,
        customerId: String?,
        orderId: String,
        storeId: String,
        requestId: String?,
        adsetId: String?,
        categoryIdOnStore: String?,
        productIdOnStore: String?,
        amount: Int,
        quantity: Int?,
        baseUrl: String?,
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        val response = service.onPurchase(
            analyticsPurchaseRequest = AnalyticsPurchaseRequest(
                sessionId = sessionId,
                deviceId = deviceId,
                customerId = customerId,
                orderId = orderId,
                storeId = storeId,
                requestId = requestId,
                adsetId = adsetId,
                categoryIdOnStore = categoryIdOnStore,
                productIdOnStore = productIdOnStore,
                quantity = quantity,
                amount = amount,
            )
        ).execute()

        checkError(response)?.let { throw it }
    }

    fun onPageView(
        sessionId: String,
        deviceId: String,
        customerId: String?,
        storeId: String,
        requestId: String?,
        adsetId: String?,
        categoryIdOnStore: String?,
        productIdOnStore: String,
        baseUrl: String?
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        val response = service.onPageView(
            analyticsPageViewRequest = AnalyticsPageViewRequest(
                sessionId = sessionId,
                deviceId = deviceId,
                customerId = customerId,
                storeId = storeId,
                requestId = requestId,
                adsetId = adsetId,
                categoryIdOnStore = categoryIdOnStore,
                productIdOnStore = productIdOnStore,
            )
        ).execute()

        checkError(response)?.let { throw it }
    }

    fun onAddToCart(
        sessionId: String,
        deviceId: String,
        customerId: String?,
        cartId: String?,
        storeId: String,
        productIdOnStore: String?,
        categoryIdOnStore: String?,
        requestId: String?,
        adsetId: String?,
        quantity: Int?,
        baseUrl: String?
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        val response = service.onAddToCart(
            analyticsAddToCartRequest = AnalyticsAddToCartRequest(
                sessionId = sessionId,
                deviceId = deviceId,
                customerId = customerId,
                cartId = cartId,
                storeId = storeId,
                productIdOnStore = productIdOnStore,
                categoryIdOnStore = categoryIdOnStore,
                requestId = requestId,
                adsetId = adsetId,
                quantity = quantity,
            )
        ).execute()

        checkError(response)?.let { throw it }
    }

    private fun checkError(response: Response<Unit>): PlatformException? =
        if (response.code() !in networkSuccessRange) {
            val platformException = RetrofitClient.exceptionHandling(response).toException()
            Log.e(
                TRACE_EXCEPTION_TAG,
                platformException.toNetworkErrorLog()
            )
            platformException
        } else null
}
