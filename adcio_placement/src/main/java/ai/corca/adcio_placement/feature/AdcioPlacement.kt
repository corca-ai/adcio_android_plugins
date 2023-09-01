package ai.corca.adcio_placement.feature

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.remote.PlacementRemote

object AdcioPlacement {

    private val adcioInfo = AdcioSuggestionInfo()
    private val placementRemote = PlacementRemote()

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

    /**
     * It smartly predicts products with high click or purchase probabilities from the client's products and returns the product information.
     */
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
        AdcioAnalytics.clearImpressionHistory()

        return placementRemote.getSuggestion(
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
