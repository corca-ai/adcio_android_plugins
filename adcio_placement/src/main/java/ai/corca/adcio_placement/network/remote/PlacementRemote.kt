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
import ai.corca.adcio_placement.network.data.response.banner.AdcioSuggestionBannerRawData
import ai.corca.adcio_placement.network.data.request.SuggestionsRequest
import ai.corca.adcio_placement.network.data.response.product.AdcioSuggestionProductRawData
import retrofit2.Response

internal class PlacementRemote {

    private val networkSuccessRange = 200..300

    fun fetchAdvertisementProducts(
        sessionId: String,
        deviceId: String,
        customerId: String? = null,
        placementId: String,
        clientId: String,
        placementPositionX: Int? = null,
        placementPositionY: Int? = null,
        fromAgent: Boolean = false,
        birthYear: Int? = null,
        gender: Gender? = null,
        area: String? = null,
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
                placementPositionX = placementPositionX,
                placementPositionY = placementPositionY,
                fromAgent = fromAgent,
                birthYear = birthYear,
                gender = gender,
                area = area,
            )
        ).execute()

        checkProductError(response)?.let { throw it }
        return response.body()?.toAdcioSuggestionRawData() ?: throw RuntimeException()
    }

    fun fetchAdvertisementBanners(
        sessionId: String,
        deviceId: String,
        customerId: String? = null,
        placementId: String,
        clientId: String,
        placementPositionX: Int? = null,
        placementPositionY: Int? = null,
        fromAgent: Boolean = false,
        birthYear: Int? = null,
        gender: Gender? = null,
        area: String? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionBannerRaw {
        val service = RetrofitClient.getPlacementService(baseUrl)
        val response = service.fetchAdvertisementBanner(
            suggestionsRequest = SuggestionsRequest(
                sessionId = sessionId,
                deviceId = deviceId,
                clientId = clientId,
                customerId = customerId,
                placementId = placementId,
                placementPositionX = placementPositionX,
                placementPositionY = placementPositionY,
                fromAgent = fromAgent,
                birthYear = birthYear,
                gender = gender,
                area = area,
            )
        ).execute()

        checkBannerError(response)?.let { throw it }
        return response.body()?.toAdcioSuggestionBannerRaw() ?: throw RuntimeException()
    }

    private fun checkBannerError(response: Response<AdcioSuggestionBannerRawData>): RuntimeException? = if (response.code() !in networkSuccessRange) {

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

    private fun checkProductError(response: Response<AdcioSuggestionProductRawData>): RuntimeException? = if (response.code() !in networkSuccessRange) {

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
