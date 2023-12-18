package ai.corca.adcio_placement.network.remote

import ai.corca.adcio_placement.enum.Gender
import ai.corca.adcio_placement.exception.BadRequestException
import ai.corca.adcio_placement.exception.DisabledPlacementException
import ai.corca.adcio_placement.exception.UnKnownException
import ai.corca.adcio_placement.exception.UnregisteredIdException
import ai.corca.adcio_placement.mapper.toAdcioSuggestionRaw
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.RetrofitClient
import ai.corca.adcio_placement.network.data.AdcioSuggestionRawData
import ai.corca.adcio_placement.network.data.request.SuggestionsRequest
import retrofit2.Response

internal class PlacementRemote {

    private val networkSuccessRange = 200..300

    fun getSuggestion(
        sessionId: String,
        deviceId: String,
        customerId: String? = null,
        placementId: String,
        placementPositionX: Int? = null,
        placementPositionY: Int? = null,
        fromAgent: Boolean = false,
        birthYear: Int? = null,
        gender: Gender? = null,
        area: String? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionRaw {
        val service = RetrofitClient.getPlacementService(baseUrl)
        val response = service.getSuggestions(
            suggestionsRequest = SuggestionsRequest(
                sessionId = sessionId,
                deviceId = deviceId,
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

        checkError(response)?.let { throw it }
        return response.body()?.toAdcioSuggestionRaw() ?: throw RuntimeException()
    }

    private fun checkError(response: Response<AdcioSuggestionRawData>): RuntimeException? = if (response.code() !in networkSuccessRange) {

        val errorResponse = RetrofitClient.exceptionHandling(response)

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
        }

        UnKnownException(
            code = errorResponse.statusCode.toString(),
            errorMessage = "Unknown error occurred"
        )
    } else null
}
