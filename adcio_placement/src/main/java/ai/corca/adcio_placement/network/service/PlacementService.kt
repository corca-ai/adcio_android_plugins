package ai.corca.adcio_placement.network.service

import ai.corca.adcio_placement.network.PlacementUrl
import ai.corca.adcio_placement.network.data.AdcioSuggestionRawData
import ai.corca.adcio_placement.network.data.request.SuggestionsRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

internal interface PlacementService {

    @POST(PlacementUrl.EndPoint.suggestions)
    fun getSuggestions(
        @Body suggestionsRequest: SuggestionsRequest
    ): Call<AdcioSuggestionRawData>
}
