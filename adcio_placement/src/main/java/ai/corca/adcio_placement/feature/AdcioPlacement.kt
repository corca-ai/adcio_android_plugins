package ai.corca.adcio_placement.feature

import ai.corca.adcio_placement.enum.Gender
import ai.corca.adcio_placement.model.banner.AdcioSuggestionBannerRaw
import ai.corca.adcio_placement.model.product.AdcioSuggestionProductRaw
import ai.corca.adcio_placement.network.data.request.Filters
import ai.corca.adcio_placement.network.remote.PlacementRemote
import com.corcaai.core.ids.SessionClient
import com.corcaai.core.ids.loadDeviceId

object AdcioPlacement {

    private val placementRemote = PlacementRemote()

    /**
     * This is a function that provides the same value as getSessionId in ADCIO Analytics.
     */
    fun getSessionId(): String =
        SessionClient.loadSessionId()

    /**
     * This is a function that provides the same value as getDeviceId in ADCIO Analytics.
     */
    fun getDeviceId(): String =
        loadDeviceId()

    /**
     * It smartly predicts products with high click or purchase probabilities from the client's products and returns the product information.
     */

    fun createRecommendationProducts(
        clientId: String,
        placementId: String? = null,
        excludingProductIds: List<String>? = null,
        categoryId: String? = null,
        birthYear: Int? = null,
        gender: Gender? = null,
        filters: Map<String, Filters>? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionProductRaw {
        return placementRemote.createRecommendationProducts(
            clientId = clientId,
            placementId = placementId ?: "",
            deviceId = loadDeviceId(),
            sessionId = SessionClient.loadSessionId(),
            customerId = "",
            excludingProductIds = excludingProductIds,
            categoryId = categoryId,
            fromAgent = true ,
            birthYear = birthYear,
            gender = gender,
            filters = filters,
            baseUrl = baseUrl,
        )
    }

    fun createRecommendationBanners(
        placementId: String? = null,
        customerId: String? = null,
        birthYear: Int? = null,
        gender: Gender? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionBannerRaw {
        return placementRemote.createRecommendationBanners(
            placementId = placementId ?: "",
            deviceId = loadDeviceId(),
            sessionId = SessionClient.loadSessionId(),
            customerId = customerId,
            fromAgent = false,
            birthYear = birthYear,
            gender = gender,
            baseUrl = baseUrl,
        )
    }

    fun createAdvertisementProducts(
        clientId: String,
        placementId: String,
        excludingProductIds: List<String>? = null,
        categoryId: String? = null,
        customerId: String? = null,
        fromAgent: Boolean = false,
        birthYear: Int? = null,
        gender: Gender? = null,
        filters: Map<String, Filters>? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionProductRaw {
        return placementRemote.createAdvertisementProducts(
            clientId = clientId,
            placementId = placementId,
            deviceId = loadDeviceId(),
            sessionId = SessionClient.loadSessionId(),
            excludingProductIds = excludingProductIds,
            categoryId = categoryId,
            customerId = customerId,
            fromAgent = fromAgent,
            birthYear = birthYear,
            gender = gender,
            filters = filters,
            baseUrl = baseUrl,
        )
    }

    fun createAdvertisementBanners(
        placementId: String,
        customerId: String? = null,
        birthYear: Int? = null,
        gender: Gender? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionBannerRaw {
        return placementRemote.createAdvertisementBanners(
            placementId = placementId,
            deviceId = loadDeviceId(),
            sessionId = SessionClient.loadSessionId(),
            customerId = customerId,
            fromAgent = false,
            birthYear = birthYear,
            gender = gender,
            baseUrl = baseUrl,
        )
    }
}
