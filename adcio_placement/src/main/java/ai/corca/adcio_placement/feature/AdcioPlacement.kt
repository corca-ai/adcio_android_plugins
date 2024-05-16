package ai.corca.adcio_placement.feature

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_placement.model.banner.AdcioSuggestionBannerRaw
import ai.corca.adcio_placement.model.product.AdcioSuggestionProductRaw
import ai.corca.adcio_placement.network.remote.PlacementRemote
import ai.corca.adcio_placement.utils.convertGender
import com.corcaai.core.ids.SessionClient
import com.corcaai.core.ids.loadDeviceId

object AdcioPlacement {

    private val placementRemote = PlacementRemote()

    /**
     * It smartly predicts products with high click or purchase probabilities from the client's products and returns the product information.
     */
    fun adcioCreateSuggestionProducts(
        clientId: String,
        placementId: String,
        customerId: String? = null,
        placementPositionX: Int? = null,
        placementPositionY: Int? = null,
        birthYear: Int? = null,
        gender: String? = null,
        area: String? = null,
        deviceId: String? = null,
        sessionId: String? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionProductRaw {
        val adcioAnalytics = AdcioAnalytics(clientId)
        adcioAnalytics.clearImpressionHistory()

        return placementRemote.fetchAdvertisementProducts(
            placementId = placementId,
            deviceId = deviceId ?: SessionClient.loadSessionId(),
            sessionId = sessionId ?: loadDeviceId(),
            clientId = clientId,
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

    fun adcioCreateSuggestionBanner(
        clientId: String,
        placementId: String,
        customerId: String? = null,
        placementPositionX: Int? = null,
        placementPositionY: Int? = null,
        birthYear: Int? = null,
        gender: String? = null,
        area: String? = null,
        deviceId: String? = null,
        sessionId: String? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionBannerRaw {
        val adcioAnalytics = AdcioAnalytics(clientId)
        adcioAnalytics.clearImpressionHistory()

        return placementRemote.fetchAdvertisementBanners(
            placementId = placementId,
            deviceId = deviceId ?: SessionClient.loadSessionId(),
            sessionId = sessionId ?: loadDeviceId(),
            clientId = clientId,
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
