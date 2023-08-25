package ai.corca.adcio_placement.network.service

import ai.corca.adcio_placement.network.PlacementUrl
import ai.corca.adcio_placement.network.data.AdcioSuggestionRawData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacementService {

    @GET(PlacementUrl.EndPoint.suggestion)
    fun getSuggestion(
        @Query("sessionId") sessionId: String,
        @Query("deviceId") deviceId: String,
        @Query("customerId") customerId: String? = null,
        @Query("placementId") placementId: String,
        @Query("placementPosX") placementPosX: Int? = null,
        @Query("placementPosY") placementPosY: Int? = null,
        @Query("fromAgent") fromAgent: Boolean = false,
        @Query("age") age: String? = null,
        @Query("gender") gender: String? = null,
        @Query("area") area: String? = null,
    ): Call<AdcioSuggestionRawData>
}
