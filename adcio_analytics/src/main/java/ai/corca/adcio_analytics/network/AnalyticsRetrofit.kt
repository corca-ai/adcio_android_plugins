package ai.corca.adcio_analytics.network

import ai.corca.adcio_analytics.network.service.AnalyticsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private var analyticsService: AnalyticsService? = null

private val okHttpClient = OkHttpClient().newBuilder()
    .addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    })
    .build()

internal fun getAnalyticsService(baseUrl: String?): AnalyticsService {
    if (analyticsService == null) {

        if (baseUrl.isNullOrBlank().not()) AnalyticsUrl.baseUrl = baseUrl ?: ""

        val analyticsRetrofit: Retrofit = Retrofit.Builder().apply {
            baseUrl(AnalyticsUrl.baseUrl)
            client(okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    val analyticsRetrofit: Retrofit = Retrofit.Builder().apply {
        baseUrl(AnalyticsUrl.baseUrl)
        client(okHttpClient)
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    return analyticsRetrofit.create(AnalyticsService::class.java)
}

private fun checkBaseUrl(baseUrl: String?): Boolean {
    if (baseUrl.isNullOrBlank()) return false
    else if (baseUrl == AnalyticsUrl.baseUrl) return false
    return true
}



