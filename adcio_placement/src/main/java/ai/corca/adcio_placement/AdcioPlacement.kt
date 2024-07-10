package ai.corca.adcio_placement

import ai.corca.generator_placement.model.BannerSuggestionRequestDto
import ai.corca.generator_placement.model.BannerSuggestionResponseDto
import ai.corca.generator_placement.model.ProductFilterOperationDto
import ai.corca.generator_placement.model.ProductSuggestionRequestDto
import ai.corca.generator_placement.model.ProductSuggestionResponseDto
import ai.corca.generator_placement.model.SuggestionRequestTarget
import android.os.Build
import com.corcaai.core.ids.SessionClient
import com.corcaai.core.ids.loadDeviceId

object AdcioPlacement {

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

    suspend fun createRecommendationProducts(
        clientId: String,
        placementId: String,
        excludingProductIds: List<String>? = null,
        baselineProductIds: List<String>? = null,
        categoryId: String? = null,
        customerId: String? = null,
        fromAgent: Boolean? = null,
        userAgent: String? = null,
        targets: List<SuggestionRequestTarget>? = null,
        filters: Map<String, ProductFilterOperationDto>? = null,
    ): ProductSuggestionResponseDto? {
        var _filters: MutableList<Map<String, ProductFilterOperationDto>>? = null

        if (filters != null) {
            val filtersArray = mutableListOf<Map<String, ProductFilterOperationDto>>()
            for ((key, condition) in filters) {
                val filter = ProductFilterOperationDto(
                    equalTo = condition.equalTo,
                    not = condition.not,
                    contains = condition.contains
                )
                filtersArray.add(mapOf(key to filter))
            }
            if (filtersArray.isNotEmpty()) {
                _filters = filtersArray
            }
        }

        return suggestionApi.recommendationsControllerRecommendProducts(
            productSuggestionRequestDto = ProductSuggestionRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                placementId = placementId,
                clientId = clientId,
                customerId = customerId,
                sdkVersion = sdkVersion,
                placementPositionX = null,
                placementPositionY = null,
                fromAgent = fromAgent,
                excludingProductIds = excludingProductIds,
                baselineProductIds = baselineProductIds,
                categoryId = categoryId,
                filters = _filters?.toList(),
                targets = targets,
                userAgent = userAgent ?: "${Build.MODEL}-${Build.VERSION.RELEASE}"
            )
        ).body()
    }

    suspend fun createRecommendationBanners(
        placementId: String,
        customerId: String? = null,
        fromAgent: Boolean? = null,
        userAgent: String? = null,
        targets: List<SuggestionRequestTarget>? = null,
    ): BannerSuggestionResponseDto? {
        return suggestionApi.recommendationsControllerRecommendBanners(
            bannerSuggestionRequestDto = BannerSuggestionRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                placementId = placementId,
                customerId = customerId,
                sdkVersion = sdkVersion,
                placementPositionX = null,
                placementPositionY = null,
                fromAgent = fromAgent,
                targets = targets,
                userAgent = userAgent ?: "${Build.MODEL}-${Build.VERSION.RELEASE}"
            )
        ).body()
    }

    suspend fun createAdvertisementProducts(
        clientId: String,
        placementId: String,
        excludingProductIds: List<String>? = null,
        baselineProductIds: List<String>? = null,
        categoryId: String? = null,
        customerId: String? = null,
        fromAgent: Boolean? = null,
        userAgent: String? = null,
        targets: List<SuggestionRequestTarget>? = null,
        filters: Map<String, ProductFilterOperationDto>? = null,
    ): ProductSuggestionResponseDto? {

        var _filters: MutableList<Map<String, ProductFilterOperationDto>>? = null

        if (filters != null) {
            val filtersArray = mutableListOf<Map<String, ProductFilterOperationDto>>()
            for ((key, condition) in filters) {
                val filter = ProductFilterOperationDto(
                    equalTo = condition.equalTo,
                    not = condition.not,
                    contains = condition.contains
                )
                filtersArray.add(mapOf(key to filter))
            }
            if (filtersArray.isNotEmpty()) {
                _filters = filtersArray
            }
        }

        return suggestionApi.advertisementsControllerAdvertiseProducts(
            productSuggestionRequestDto = ProductSuggestionRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                placementId = placementId,
                clientId = clientId,
                customerId = customerId,
                sdkVersion = sdkVersion,
                placementPositionX = null,
                placementPositionY = null,
                fromAgent = fromAgent,
                excludingProductIds = excludingProductIds,
                baselineProductIds = baselineProductIds,
                categoryId = categoryId,
                filters = _filters?.toList(),
                targets = targets,
                userAgent = userAgent ?: "${Build.MODEL}-${Build.VERSION.RELEASE}"
            )
        ).body()
    }

    suspend fun createAdvertisementBanners(
        placementId: String,
        customerId: String? = null,
        fromAgent: Boolean? = null,
        userAgent: String? = null,
        targets: List<SuggestionRequestTarget>? = null,
    ): BannerSuggestionResponseDto? {
        return suggestionApi.advertisementsControllerAdvertiseBanners(
            bannerSuggestionRequestDto = BannerSuggestionRequestDto(
                sessionId = SessionClient.loadSessionId(),
                deviceId = loadDeviceId(),
                placementId = placementId,
                customerId = customerId,
                sdkVersion = sdkVersion,
                placementPositionX = null,
                placementPositionY = null,
                fromAgent = fromAgent,
                targets = targets,
                userAgent = userAgent ?: "${Build.MODEL}-${Build.VERSION.RELEASE}"
            )
        ).body()
    }
}
