package ai.corca.adcio_placement.feature

import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.remote.PlacementRemote

object AdcioPlacement {

    val adcioInfo = AdcioSuggestionInfo()

    fun getDeviceId(
        otherInfo: AdcioSuggestionInfo? = null
    ): String {
        return otherInfo?.getDeviceId() ?: adcioInfo.getDeviceId()
    }

    fun getSessionId(
        otherInfo: AdcioSuggestionInfo? = null
    ): String {
        return otherInfo?.getSessionId() ?: adcioInfo.getSessionId()
    }

    fun adcioSuggest(
        placementId: String,
        otherInfo: AdcioSuggestionInfo? = null,
        customerId: String? = null,
        placementPosX: Int? = null,
        placementPosY: Int? = null,
        age: String? = null,
        gender: String? = null,
        area: String? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionRaw {
        return PlacementRemote().getSuggestion(
            placementId = placementId,
            sessionId = getSessionId(otherInfo),
            deviceId = getDeviceId(otherInfo),
            customerId = customerId,
            placementPosX = placementPosX,
            placementPosY = placementPosY,
            fromAgent = false,
            age = age,
            gender = gender,
            area = area,
            baseUrl = baseUrl,
        )
    }
}
