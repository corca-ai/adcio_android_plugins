package ai.corca.adcio_analytics.network.remote

import ai.corca.adcio_analytics.exception.PlatformException
import ai.corca.adcio_analytics.mapper.toAnalyticsRequest
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.network.RetrofitClient
import ai.corca.adcio_analytics.network.data.pageview.AnalyticsPageViewRequest
import ai.corca.adcio_analytics.network.data.toException
import ai.corca.adcio_analytics.utils.TRACE_EXCEPTION_TAG
import ai.corca.adcio_analytics.utils.toNetworkErrorLog
import android.util.Log
import com.corcaai.adcio_core.feature.AdcioCore
import retrofit2.Response

internal class AnalyticsRemote {

    private val networkSuccessRange = 200 until 300

    fun onImpression(
        adcioLogOption: AdcioLogOption,
        baseUrl: String?,
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        val response = service.onImpression(
            analyticsRequest = adcioLogOption.toAnalyticsRequest()
        ).execute()

        checkError(response)?.let { throw it }
    }

    fun onClick(
        adcioLogOption: AdcioLogOption,
        baseUrl: String?,
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        val response = service.onClick(
            analyticsRequest = adcioLogOption.toAnalyticsRequest()
        ).execute()

        checkError(response)?.let { throw it }
    }

    fun onPurchase(
        adcioLogOption: AdcioLogOption,
        amount: Int,
        baseUrl: String?,
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        val response = service.onPurchase(
            analyticsRequest = adcioLogOption.toAnalyticsRequest(amount)
        ).execute()

        checkError(response)?.let { throw it }
    }

    fun onPageView(
        path: String,
        sessionId: String = AdcioCore.sessionId,
        deviceId: String = AdcioCore.deviceId,
        customerId: String? = null,
        storeId: String = AdcioCore.storeId!!,
        productCode: String? = null,
        title: String,
        referrer: String? = null,
        baseUrl: String?
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        val response = service.onPageView(
            analyticsPageViewRequest = AnalyticsPageViewRequest(
                path = path,
                sessionId = sessionId,
                deviceId = deviceId,
                customerId = customerId,
                storeId = storeId,
                productCode = productCode,
                title = title,
                referrer = referrer
            )
        ).execute()

        checkError(response)?.let { throw it }
    }

    private fun checkError(response: Response<Unit>): PlatformException? = if (response.code() !in networkSuccessRange) {
        val platformException = RetrofitClient.exceptionHandling(response).toException()
        Log.e(
            TRACE_EXCEPTION_TAG,
            platformException.toNetworkErrorLog()
        )
        platformException
    } else null
}
