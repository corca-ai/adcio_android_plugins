package ai.corca.adcio_placement.feature

import ai.corca.adcio_placement.enum.Gender
import ai.corca.adcio_placement.model.banner.AdcioSuggestionBannerRaw
import ai.corca.adcio_placement.model.product.AdcioSuggestionProductRaw
import ai.corca.adcio_placement.network.data.request.Filters
import ai.corca.adcio_placement.network.data.request.Targets
import ai.corca.adcio_placement.network.remote.PlacementRemote
import android.os.Build
import com.corcaai.core.ids.SessionClient
import com.corcaai.core.ids.loadDeviceId
import okhttp3.internal.userAgent

object AdcioPlacement {

    private val sdkVersion = "Android 1.4.1"

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
        placementId: String,
        excludingProductIds: List<String>? = null,
        baselineProductIds: List<String>? = null,
        categoryId: String? = null,
        customerId: String? = null,
        fromAgent: Boolean = false,
        userAgent: String? = null,
        filters: List<Map<String, Filters>>? = null,
        targets: List<Targets>? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionProductRaw {
        return placementRemote.createRecommendationProducts(
            clientId = clientId,
            placementId = placementId,
            deviceId = loadDeviceId(),
            sessionId = SessionClient.loadSessionId(),
            customerId = customerId,
            baselineProductIds = baselineProductIds,
            excludingProductIds = excludingProductIds,
            categoryId = categoryId,
            fromAgent = fromAgent,
            userAgent = userAgent ?: "${Build.MODEL} - ${Build.VERSION.RELEASE}",
            filters = filters,
            targets = targets,
            sdkVersion = sdkVersion,
            baseUrl = baseUrl,
        )
    }

    fun createRecommendationBanners(
        placementId: String,
        customerId: String? = null,
        fromAgent: Boolean = false,
        userAgent: String? = null,
        targets: List<Targets>? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionBannerRaw {
        return placementRemote.createRecommendationBanners(
            placementId = placementId,
            deviceId = loadDeviceId(),
            sessionId = SessionClient.loadSessionId(),
            customerId = customerId,
            fromAgent = fromAgent,
            userAgent = userAgent ?: "${Build.MODEL} - ${Build.VERSION.RELEASE}",
            sdkVersion = sdkVersion,
            targets = targets,
            baseUrl = baseUrl,
        )
    }

    fun createAdvertisementProducts(
        clientId: String,
        placementId: String,
        excludingProductIds: List<String>? = null,
        baselineProductIds: List<String>? = null,
        categoryId: String? = null,
        customerId: String? = null,
        fromAgent: Boolean = false,
        userAgent: String? = null,
        filters: List<Map<String, Filters>>? = null,
        targets: List<Targets>? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionProductRaw {
        return placementRemote.createAdvertisementProducts(
            clientId = clientId,
            placementId = placementId,
            deviceId = loadDeviceId(),
            sessionId = SessionClient.loadSessionId(),
            baselineProductIds = baselineProductIds,
            excludingProductIds = excludingProductIds,
            categoryId = categoryId,
            customerId = customerId,
            fromAgent = fromAgent,
            userAgent = userAgent ?: "${Build.MODEL} - ${Build.VERSION.RELEASE}",
            sdkVersion = sdkVersion,
            filters = filters,
            targets = targets,
            baseUrl = baseUrl,
        )
    }

    fun createAdvertisementBanners(
        placementId: String,
        customerId: String? = null,
        fromAgent: Boolean = false,
        userAgent: String? = null,
        targets: List<Targets>? = null,
        baseUrl: String? = null,
    ): AdcioSuggestionBannerRaw {
        return placementRemote.createAdvertisementBanners(
            placementId = placementId,
            deviceId = loadDeviceId(),
            sessionId = SessionClient.loadSessionId(),
            customerId = customerId,
            fromAgent = fromAgent,
            sdkVersion = sdkVersion,
            userAgent = userAgent ?: "${Build.MODEL} - ${Build.VERSION.RELEASE}",
            targets = targets,
            baseUrl = baseUrl,
        )
    }
}
