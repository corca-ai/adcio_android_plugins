package ai.corca.adcio_placement.network.remote

import ai.corca.adcio_placement.exception.PlatformException
import ai.corca.adcio_placement.mapper.toAdcioSuggestionRaw
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.RetrofitClient
import ai.corca.adcio_placement.network.data.AdcioSuggestionRawData
import ai.corca.adcio_placement.network.data.toException
import ai.corca.adcio_placement.utils.TRACE_EXCEPTION_TAG
import ai.corca.adcio_placement.utils.toNetworkErrorLog
import android.util.Log
import retrofit2.Response
import java.lang.RuntimeException

internal class PlacementRemote {

    private val networkSuccessRange = 200 until 300

    fun getSuggestion(
        sessionId: String,
        deviceId: String,
        customerId: String? = null,
        placementId: String,
        placementPosX: Int? = null,
        placementPosY: Int? = null,
        fromAgent: Boolean = false,
        age: String? = null,
        gender: String? = null,
        area: String? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionRaw {
        val service = RetrofitClient.getPlacementService(baseUrl)
        val response = service.getSuggestion(
            sessionId = sessionId,
            deviceId = deviceId,
            customerId = customerId,
            placementId = placementId,
            placementPosX = placementPosX,
            placementPosY = placementPosY,
            fromAgent = fromAgent,
            age = age,
            gender = gender,
            area = area,
        ).execute()

        checkError(response)?.let { throw it }
        return response.body()?.toAdcioSuggestionRaw() ?: throw RuntimeException()
    }

    private fun checkError(response: Response<AdcioSuggestionRawData>): PlatformException? = if (response.code() !in networkSuccessRange) {
        val platformException = RetrofitClient.exceptionHandling(response).toException()
        Log.e(
            TRACE_EXCEPTION_TAG,
            platformException.toNetworkErrorLog()
        )
        platformException
    } else null
}