package ai.corca.adcio_placement.network.service

import ai.corca.adcio_placement.network.PlacementUrl
import ai.corca.adcio_placement.network.data.response.banner.AdcioSuggestionBannerRawData
import ai.corca.adcio_placement.network.data.request.SuggestionsRequest
import ai.corca.adcio_placement.network.data.response.product.AdcioSuggestionProductRawData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

internal interface PlacementService {

    @POST(PlacementUrl.EndPoint.adProducts)
    fun fetchAdvertisementProduct(
        @Body suggestionsRequest: SuggestionsRequest
    ): Call<AdcioSuggestionProductRawData>

    @POST(PlacementUrl.EndPoint.adBanners)
    fun fetchAdvertisementBanner(
        @Body suggestionsRequest: SuggestionsRequest
    ): Call<AdcioSuggestionBannerRawData>

    @POST(PlacementUrl.EndPoint.recProducts)
    fun fetchRecommendationsProduct(
        @Body suggestionsRequest: SuggestionsRequest
    ): Call<AdcioSuggestionProductRawData>

    @POST(PlacementUrl.EndPoint.recBanners)
    fun fetchRecommendationsBanner(
        @Body suggestionsRequest: SuggestionsRequest
    ): Call<AdcioSuggestionBannerRawData>
}
