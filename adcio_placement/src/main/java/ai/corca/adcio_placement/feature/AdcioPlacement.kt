package ai.corca.adcio_placement.feature

import ai.corca.adcio_analytics.feature.AdcioAnalyticsHistory
import ai.corca.adcio_placement.exception.NotInitializedException
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.remote.PlacementRemote
import android.util.Log

object AdcioPlacement {

    private lateinit var adcioAnalyticsHistory: AdcioAnalyticsHistory
    private var isInitialized: Boolean = false

    fun initPlacement(
        adcioAnalyticsHistory: AdcioAnalyticsHistory
    ) {
        Log.d("TestTestTest", "in Placement: ${adcioAnalyticsHistory.hashCode()}")
        isInitialized = true
        this.adcioAnalyticsHistory = adcioAnalyticsHistory
    }

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
        if (!isInitialized) throw NotInitializedException()

        adcioAnalyticsHistory.clearHistories()
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
