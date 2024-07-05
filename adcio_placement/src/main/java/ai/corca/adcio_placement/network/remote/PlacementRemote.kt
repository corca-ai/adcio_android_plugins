package ai.corca.adcio_placement.network.remote

import ai.corca.adcio_placement.enum.Gender
import ai.corca.adcio_placement.exception.BadRequestException
import ai.corca.adcio_placement.exception.DisabledPlacementException
import ai.corca.adcio_placement.exception.UnKnownException
import ai.corca.adcio_placement.exception.UnregisteredIdException
import ai.corca.adcio_placement.mapper.toAdcioSuggestionBannerRaw
import ai.corca.adcio_placement.mapper.toAdcioSuggestionRawData
import ai.corca.adcio_placement.model.banner.AdcioSuggestionBannerRaw
import ai.corca.adcio_placement.model.product.AdcioSuggestionProductRaw
import ai.corca.adcio_placement.network.RetrofitClient
import ai.corca.adcio_placement.network.data.request.Filters
import ai.corca.adcio_placement.network.data.response.banner.AdcioSuggestionBannerRawData
import ai.corca.adcio_placement.network.data.request.SuggestionsRequest
import ai.corca.adcio_placement.network.data.request.Targets
import ai.corca.adcio_placement.network.data.response.product.AdcioSuggestionProductRawData
import okhttp3.internal.userAgent
import retrofit2.Response
import java.util.logging.Filter

internal class PlacementRemote {

    private val networkSuccessRange = 200..300

    fun createRecommendationProducts(
        clientId: String,
        sessionId: String,
        deviceId: String,
        customerId: String? = null,
        placementId: String,
        categoryId: String? = null,
        placementPositionX: Int? = null,
        placementPositionY: Int? = null,
        baselineProductIds: List<String>? = null,
        excludingProductIds: List<String>? = null,
        fromAgent: Boolean = false,
        userAgent: String,
        filters: List<Map<String, Filters>>? = null,
        sdkVersion: String,
        targets: List<Targets>? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionProductRaw {
        val service = RetrofitClient.getPlacementService(baseUrl)

        val response = service.fetchRecommendationsProduct(
            suggestionsRequest = SuggestionsRequest(
                clientId = clientId,
                sessionId = sessionId,
                deviceId = deviceId,
                customerId = customerId,
                placementId = placementId,
                categoryId = categoryId,
                baselineProductIds = baselineProductIds,
                excludingProductIds = excludingProductIds,
                placementPositionX = placementPositionX,
                placementPositionY = placementPositionY,
                fromAgent = fromAgent,
                userAgent = userAgent,
                filters = filters,
                sdkVersion = sdkVersion,
                targets = targets
            )
        ).execute()

        checkProductError(response)?.let { throw it }
        return response.body()?.toAdcioSuggestionRawData() ?: throw RuntimeException()
    }

    fun createRecommendationBanners(
        sessionId: String,
        deviceId: String,
        customerId: String? = null,
        placementId: String,
        placementPositionX: Int? = null,
        placementPositionY: Int? = null,
        fromAgent: Boolean = false,
        userAgent: String,
        sdkVersion: String,
        targets: List<Targets>? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionBannerRaw {
        val service = RetrofitClient.getPlacementService(baseUrl)
        val response = service.fetchRecommendationsBanner(
            suggestionsRequest = SuggestionsRequest(
                sessionId = sessionId,
                deviceId = deviceId,
                customerId = customerId,
                placementId = placementId,
                placementPositionX = placementPositionX,
                placementPositionY = placementPositionY,
                fromAgent = fromAgent,
                userAgent = userAgent,
                sdkVersion = sdkVersion,
                targets = targets,
            )
        ).execute()

        checkBannerError(response)?.let { throw it }
        return response.body()?.toAdcioSuggestionBannerRaw() ?: throw RuntimeException()
    }

    fun createAdvertisementProducts(
        clientId: String,
        sessionId: String,
        deviceId: String,
        customerId: String? = null,
        placementId: String,
        categoryId: String? = null,
        placementPositionX: Int? = null,
        placementPositionY: Int? = null,
        baselineProductIds: List<String>? = null,
        excludingProductIds: List<String>? = null,
        fromAgent: Boolean = false,
        userAgent: String,
        filters: List<Map<String, Filters>>? = null,
        sdkVersion: String,
        targets: List<Targets>? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionProductRaw {
        val service = RetrofitClient.getPlacementService(baseUrl)
        
        val response = service.fetchAdvertisementProduct(
            suggestionsRequest = SuggestionsRequest(
                sessionId = sessionId,
                deviceId = deviceId,
                clientId = clientId,
                customerId = customerId,
                placementId = placementId,
                categoryId = categoryId,
                baselineProductIds = baselineProductIds,
                excludingProductIds = excludingProductIds,
                placementPositionX = placementPositionX,
                placementPositionY = placementPositionY,
                fromAgent = fromAgent,
                userAgent = userAgent,
                filters = filters,
                targets = targets,
                sdkVersion = sdkVersion
            )
        ).execute()

        checkProductError(response)?.let { throw it }
        return response.body()?.toAdcioSuggestionRawData() ?: throw RuntimeException()
    }

    fun createAdvertisementBanners(
        sessionId: String,
        deviceId: String,
        customerId: String? = null,
        placementId: String,
        placementPositionX: Int? = null,
        placementPositionY: Int? = null,
        fromAgent: Boolean = false,
        userAgent: String,
        sdkVersion: String,
        targets: List<Targets>? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionBannerRaw {
        val service = RetrofitClient.getPlacementService(baseUrl)
        val response = service.fetchAdvertisementBanner(
            suggestionsRequest = SuggestionsRequest(
                sessionId = sessionId,
                deviceId = deviceId,
                customerId = customerId,
                placementId = placementId,
                placementPositionX = placementPositionX,
                placementPositionY = placementPositionY,
                fromAgent = fromAgent,
                userAgent = userAgent,
                targets = targets,
                sdkVersion = sdkVersion
            )
        ).execute()

        checkBannerError(response)?.let { throw it }
        return response.body()?.toAdcioSuggestionBannerRaw() ?: throw RuntimeException()
    }

    private fun checkBannerError(response: Response<AdcioSuggestionBannerRawData>): RuntimeException? =
        if (response.code() !in networkSuccessRange) {

            val errorResponse = RetrofitClient.exceptionBannerHandling(response)

            when (errorResponse.statusCode) {
                400 -> BadRequestException(
                    errorMessage = errorResponse.message.toString()
                )

                404 -> {
                    if (errorResponse.message == 12001) {
                        UnregisteredIdException()
                    } else {
                        DisabledPlacementException()
                    }
                }

                else -> {
                    UnKnownException(
                        code = errorResponse.statusCode.toString(),
                        errorMessage = "Unknown error occurred"
                    )
                }
            }
        } else null

    private fun checkProductError(response: Response<AdcioSuggestionProductRawData>): RuntimeException? =
        if (response.code() !in networkSuccessRange) {

            val errorResponse = RetrofitClient.exceptionProductHandling(response)

            when (errorResponse.statusCode) {
                400 -> BadRequestException(
                    errorMessage = errorResponse.message.toString()
                )

                404 -> {
                    if (errorResponse.message == 12001) {
                        UnregisteredIdException()
                    } else {
                        DisabledPlacementException()
                    }
                }

                else -> {
                    UnKnownException(
                        code = errorResponse.statusCode.toString(),
                        errorMessage = "Unknown error occurred"
                    )
                }
            }
        } else null
}
