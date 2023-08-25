package ai.corca.adcio_analytics.network

import ai.corca.adcio_analytics.exception.UNKNOWN_EXCEPTION_MESSAGE
import ai.corca.adcio_analytics.network.data.ErrorResponse
import ai.corca.adcio_analytics.network.service.AnalyticsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.RuntimeException

internal object RetrofitClient {
    private var analyticsService: AnalyticsService? = null
    private var retrofit: Retrofit? = null

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    // TODO RuntimeException 처리
    fun getAnalyticsService(baseUrl: String?): AnalyticsService {

        if (analyticsService == null) {
            // service가 초기화되지 않은 경우 -> 공통적으로 serivce 초기화 필요.
            // 사용자가 요청한 baseUrl이 비었지 않은 경우
            // ex) 첫 실행 후, 첫 함수 호출에서 자신만의 baseUrl을 넘긴 경우.
            // AnalyticsUrl에 새로 받은 BaseUrl 등록.
            if (baseUrl.isNullOrBlank().not()) AnalyticsUrl.baseUrl = baseUrl ?: ""

            // else -> 사용자가 요청한 baseurl이 null이거나 빈 경우.
            // 기본으로 등록된 baseUrl 사용하겠다.
            createRetrofit()
            analyticsService = retrofit?.create(AnalyticsService::class.java)
            return analyticsService ?: throw RuntimeException()
        } else {
            // 초기화된 service 객체가 있는 경우.
            // 등록된 객체의 값을 비교한다.
            return if (baseUrl.isNullOrBlank()) {
                // 사용자가 넘겨준 baseUrl 값이 없을 경우.
                // 이미 만들어진 baseUrl을 사용하겠다.
                analyticsService ?: throw RuntimeException()
            } else {
                // 사용자가 넘겨준 baseUrl 값이 있는 경우.
                if (baseUrl == AnalyticsUrl.baseUrl) {
                    // 기존의 baseUrl과 같다. -> 이미 만들어진 객체.
                    analyticsService ?: throw RuntimeException()
                } else {
                    // 기존의 baseUrl과 다르다? -> 새로운 객체가 필요하다.
                    AnalyticsUrl.baseUrl = baseUrl
                    createRetrofit()
                    analyticsService = retrofit?.create(AnalyticsService::class.java)
                    analyticsService ?: throw RuntimeException()
                }
            }
        }
    }

    fun exceptionHandling(response: Response<Unit>): ErrorResponse {
        val errorResponse = response.errorBody()?.let {
            retrofit?.responseBodyConverter<ErrorResponse>(
                ErrorResponse::class.java,
                ErrorResponse::class.java.annotations
            )?.convert(it)
        }?.message ?: listOf(UNKNOWN_EXCEPTION_MESSAGE)
        return ErrorResponse(
            statusCode = response.code(),
            message = errorResponse
        )
    }

    private fun createRetrofit() {
        retrofit = Retrofit.Builder().apply {
            baseUrl(AnalyticsUrl.baseUrl)
            client(okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }
}
