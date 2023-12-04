package ai.corca.adcio_placement.feature

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.remote.PlacementRemote
import ai.corca.adcio_placement.utils.convertGender
import com.corcaai.adcio_core.feature.AdcioCore

object AdcioPlacement {

    private val placementRemote = PlacementRemote()

    /**
     * It smartly predicts products with high click or purchase probabilities from the client's products and returns the product information.
     */
    fun adcioCreateSuggestion(
        placementId: String,
        customerId: String? = null,
        placementPositionX: Int? = null,
        placementPositionY: Int? = null,
        birthYear: Int? = null,
        gender: String? = null,
        area: String? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionRaw {
        AdcioAnalytics.clearImpressionHistory()

        return placementRemote.getSuggestion(
            placementId = placementId,
            sessionId = AdcioCore.sessionId,
            deviceId = AdcioCore.deviceId,
            customerId = customerId,
            placementPositionX = placementPositionX,
            placementPositionY = placementPositionY,
            fromAgent = false,
            birthYear = birthYear,
            gender = convertGender(gender),
            area = area,
            baseUrl = baseUrl,
        )
    }
}
