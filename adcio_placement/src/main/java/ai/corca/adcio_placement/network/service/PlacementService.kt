package ai.corca.adcio_placement.network.service

import ai.corca.adcio_placement.network.PlacementUrl
import ai.corca.adcio_placement.network.data.AdcioSuggestionRawData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PlacementService {

    @GET(PlacementUrl.EndPoint.suggestion)
    fun getSuggestion(
        @Query("sessionId") sessionId: String,
        @Query("deviceId") deviceId: String,
        @Query("customerId") customerId: String?,
        @Query("placementId") placementId: String,
        @Query("placementPosX") placementPosX: Int?,
        @Query("placementPosY") placementPosY: Int?,
        @Query("fromAgent") fromAgent: Boolean,
        @Query("age") age: String?,
        @Query("gender") gender: String?,
        @Query("area") area: String?,
    ): Call<AdcioSuggestionRawData>
}
