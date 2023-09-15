package ai.corca.adcio_placement.feature

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.remote.PlacementRemote
import com.corcaai.adcio_core.feature.AdcioInfo

object AdcioPlacement {

    private val adcioInfo = AdcioInfo
    private val placementRemote = PlacementRemote()

    /**
     * You can obtain the deviceId registered.
     * @param otherInfo register other device info.
     */

    fun getDeviceId(
        otherInfo: AdcioInfo? = null
    ): String {
        return otherInfo?.getDeviceId() ?: adcioInfo.getDeviceId()
    }

    /**
     * You can obtain the sessionId registered.
     * @param otherInfo register other device info.
     */
    fun getSessionId(
        otherInfo: AdcioInfo? = null
    ): String {
        return otherInfo?.getSessionId() ?: adcioInfo.getSessionId()
    }

    /**
     * It smartly predicts products with high click or purchase probabilities from the client's products and returns the product information.
     */
    fun adcioSuggest(
        placementId: String,
        otherInfo: AdcioInfo? = null,
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
