package ai.corca.adcio_analytics.network.remote

import ai.corca.adcio_analytics.mapper.toAnalyticsRequest
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.network.RetrofitClient

class AnalyticsRemote {

    fun onImpression(
        adcioLogOption: AdcioLogOption,
        baseUrl: String?,
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        service.onImpression(
            analyticsRequest = adcioLogOption.toAnalyticsRequest()
        )
    }

    fun onClick(
        adcioLogOption: AdcioLogOption,
        baseUrl: String?,
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        service.onClick(
            analyticsRequest = adcioLogOption.toAnalyticsRequest()
        )
    }

    fun onPurchase(
        adcioLogOption: AdcioLogOption,
        amount: Int,
        baseUrl: String?,
    ) {
        val service = RetrofitClient.getAnalyticsService(baseUrl)
        service.onPurchase(
            analyticsRequest = adcioLogOption.toAnalyticsRequest(amount)
        )
    }
}