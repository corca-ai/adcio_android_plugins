package ai.corca.adcio_placement.feature

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.remote.PlacementRemote
import com.corcaai.adcio_core.feature.AdcioInfo

object AdcioPlacement {

    private val placementRemote = PlacementRemote()

    /**
     * It smartly predicts products with high click or purchase probabilities from the client's products and returns the product information.
     */
    fun adcioSuggest(
        placementId: String,
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
            sessionId = AdcioInfo.sessionId,
            deviceId = AdcioInfo.deviceId!!,
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
