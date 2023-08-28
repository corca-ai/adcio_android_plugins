package ai.corca.adcio_placement.feature

import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.remote.PlacementRemote

object AdcioPlacement {

    fun getDeviceId() = AdcioSuggestionInfo.getDeviceId()

    fun getSessionId() = AdcioSuggestionInfo.getSessionId()

    fun adcioSuggest(
        placementId: String,
        sessionId: String = AdcioSuggestionInfo.getSessionId(),
        deviceId: String = AdcioSuggestionInfo.getDeviceId(),
        customerId: String? = null,
        placementPosX: Int? = null,
        placementPosY: Int? = null,
        fromAgent: Boolean = false,
        age: String? = null,
        gender: String? = null,
        area: String? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionRaw {
        return PlacementRemote().getSuggestion(
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
            baseUrl = baseUrl,
        )
    }
}
