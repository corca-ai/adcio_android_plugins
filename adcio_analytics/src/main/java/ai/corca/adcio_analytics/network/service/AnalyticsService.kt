package ai.corca.adcio_analytics.network.service

import ai.corca.adcio_analytics.network.AnalyticsUrl
import ai.corca.adcio_analytics.network.data.AnalyticsRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AnalyticsService {

    @POST(AnalyticsUrl.EndPoint.impression)
    fun onImpression(
        @Body analyticsRequest: AnalyticsRequest
    ): Call<Unit>

    @POST(AnalyticsUrl.EndPoint.click)
    fun onClick(
        @Body analyticsRequest: AnalyticsRequest
    ): Call<Unit>

    @POST(AnalyticsUrl.EndPoint.purchase)
    fun onPurchase(
        @Body analyticsRequest: AnalyticsRequest
    ): Call<Unit>
}
