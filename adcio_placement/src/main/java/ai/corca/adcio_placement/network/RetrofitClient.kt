package ai.corca.adcio_placement.network

import ai.corca.adcio_placement.network.data.response.banner.AdcioSuggestionBannerRawData
import ai.corca.adcio_placement.network.data.response.banner.ErrorResponse
import ai.corca.adcio_placement.network.data.response.product.AdcioSuggestionProductRawData
import ai.corca.adcio_placement.network.service.PlacementService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitClient {
    private var placementService: PlacementService? = null
    private lateinit var retrofit: Retrofit

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(
            interceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    fun getPlacementService(baseUrl: String?): PlacementService {
        if (placementService == null) {
            if (baseUrl.isNullOrBlank().not()) PlacementUrl.baseUrl = baseUrl ?: ""

            createRetrofit()
            placementService = retrofit.create(PlacementService::class.java)
            return placementService ?: throw RuntimeException()
        } else {
            return if (baseUrl.isNullOrBlank()) {
                placementService ?: throw RuntimeException()
            } else {
                if (baseUrl == PlacementUrl.baseUrl) {
                    placementService ?: throw RuntimeException()
                } else {
                    PlacementUrl.baseUrl = baseUrl
                    createRetrofit()
                    placementService = retrofit.create(PlacementService::class.java)
                    placementService ?: throw RuntimeException()
                }
            }
        }
    }

    fun exceptionBannerHandling(response: Response<AdcioSuggestionBannerRawData>): ErrorResponse {
        val errorResponse = response.errorBody()?.let {
            retrofit.responseBodyConverter<ErrorResponse>(
                ErrorResponse::class.java,
                ErrorResponse::class.java.annotations
            ).convert(it)
        }?.message

        return ErrorResponse(
            statusCode = response.code(),
            message = errorResponse!!
        )
    }

    fun exceptionProductHandling(response: Response<AdcioSuggestionProductRawData>): ErrorResponse {
        val errorResponse = response.errorBody()?.let {
            retrofit.responseBodyConverter<ErrorResponse>(
                ErrorResponse::class.java,
                ErrorResponse::class.java.annotations
            ).convert(it)
        }?.message

        return ErrorResponse(
            statusCode = response.code(),
            message = errorResponse!!
        )
    }

    private fun createRetrofit() {
        retrofit = Retrofit.Builder().apply {
            baseUrl(PlacementUrl.baseUrl)
            client(okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }
}
