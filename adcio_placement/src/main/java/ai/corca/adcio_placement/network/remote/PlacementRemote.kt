package ai.corca.adcio_placement.network.remote

import ai.corca.adcio_placement.enum.Gender
import ai.corca.adcio_placement.exception.BadRequestException
import ai.corca.adcio_placement.exception.DisabledPlacementException
import ai.corca.adcio_placement.exception.PlatformException
import ai.corca.adcio_placement.exception.UnregisteredIdException
import ai.corca.adcio_placement.mapper.toAdcioSuggestionRaw
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.RetrofitClient
import ai.corca.adcio_placement.network.data.AdcioSuggestionRawData
import ai.corca.adcio_placement.network.data.request.SuggestionsRequest
import ai.corca.adcio_placement.network.data.toException
import ai.corca.adcio_placement.utils.TRACE_EXCEPTION_TAG
import ai.corca.adcio_placement.utils.toNetworkErrorLog
import android.util.Log
import retrofit2.Response
import java.lang.RuntimeException

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

    private fun checkError(response: Response<AdcioSuggestionRawData>): PlatformException? = if (response.code() !in networkSuccessRange) {
        val exception = RetrofitClient.exceptionHandling(response)

        Log.e(
            TRACE_EXCEPTION_TAG,
            exception.toException().toNetworkErrorLog()
        )

        when (exception.statusCode) {
            400 -> BadRequestException(
                errorMessage = "placementId must be a UUID"
            )
            404 -> {
                if (exception.message == 12001) {
                    UnregisteredIdException()
                } else {
                    DisabledPlacementException()
                }
            }
            else -> PlatformException(
                code = exception.statusCode.toString(),
                errorMessage = "Unknown error occurred"
            )
        }
    } else null
}
