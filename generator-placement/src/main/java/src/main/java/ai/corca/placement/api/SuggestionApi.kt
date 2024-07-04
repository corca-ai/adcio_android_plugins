package ai.corca.placement.api

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.squareup.moshi.Json

import ai.corca.placement.model.BannerSuggestionRequestDto
import ai.corca.placement.model.BannerSuggestionResponseDto
import ai.corca.placement.model.NestJSErrorSchema
import ai.corca.placement.model.ProductSuggestionRequestDto
import ai.corca.placement.model.ProductSuggestionResponseDto

interface SuggestionApi {
    /**
     * 
     * Fetch a personalized banner for advertisement.
     * Responses:
     *  - 201: 
     *  - 400: <b>SUGGESTION.INVALID_PLACEMENT_TYPE</b> &nbsp; `12003` 
     *  - 404: <b>SUGGESTION.NO_ACTIVATED_PLACEMENT</b> &nbsp; `12004` <br/><br/><b>SUGGESTION.PLACEMENT_NOT_FOUND</b> &nbsp; `12001` 
     *
     * @param bannerSuggestionRequestDto 
     * @return [BannerSuggestionResponseDto]
     */
    @POST("v1/advertisements/banners")
    suspend fun advertisementsControllerAdvertiseBanners(@Body bannerSuggestionRequestDto: BannerSuggestionRequestDto): Response<BannerSuggestionResponseDto>

    /**
     * 
     * Fetch a personalized product for advertisement.
     * Responses:
     *  - 201: 
     *  - 400: <b>SUGGESTION.INVALID_PLACEMENT_TYPE</b> &nbsp; `12003` 
     *  - 404: <b>SUGGESTION.NO_ACTIVATED_PLACEMENT</b> &nbsp; `12004` <br/><br/><b>SUGGESTION.PLACEMENT_NOT_FOUND</b> &nbsp; `12001` 
     *
     * @param productSuggestionRequestDto 
     * @return [ProductSuggestionResponseDto]
     */
    @POST("v1/advertisements/products")
    suspend fun advertisementsControllerAdvertiseProducts(@Body productSuggestionRequestDto: ProductSuggestionRequestDto): Response<ProductSuggestionResponseDto>

    /**
     * 
     * Fetch a personalized banner for recommendation.
     * Responses:
     *  - 201: 
     *  - 400: <b>SUGGESTION.INVALID_PLACEMENT_TYPE</b> &nbsp; `12003` 
     *  - 404: <b>SUGGESTION.NO_ACTIVATED_PLACEMENT</b> &nbsp; `12004` <br/><br/><b>SUGGESTION.PLACEMENT_NOT_FOUND</b> &nbsp; `12001` 
     *
     * @param bannerSuggestionRequestDto 
     * @return [BannerSuggestionResponseDto]
     */
    @POST("v1/recommendations/banners")
    suspend fun recommendationsControllerRecommendBanners(@Body bannerSuggestionRequestDto: BannerSuggestionRequestDto): Response<BannerSuggestionResponseDto>

    /**
     * 
     * Fetch a personalized product for recommendation.
     * Responses:
     *  - 201: 
     *  - 400: <b>SUGGESTION.INVALID_PLACEMENT_TYPE</b> &nbsp; `12003` 
     *  - 404: <b>SUGGESTION.NO_ACTIVATED_PLACEMENT</b> &nbsp; `12004` <br/><br/><b>SUGGESTION.PLACEMENT_NOT_FOUND</b> &nbsp; `12001` 
     *
     * @param productSuggestionRequestDto 
     * @return [ProductSuggestionResponseDto]
     */
    @POST("v1/recommendations/products")
    suspend fun recommendationsControllerRecommendProducts(@Body productSuggestionRequestDto: ProductSuggestionRequestDto): Response<ProductSuggestionResponseDto>

    /**
     * 
     * Fetch a personalized banner for advertisement.
     * Responses:
     *  - 201: 
     *  - 400: <b>SUGGESTION.INVALID_PLACEMENT_TYPE</b> &nbsp; `12003` 
     *  - 404: <b>SUGGESTION.NO_ACTIVATED_PLACEMENT</b> &nbsp; `12004` <br/><br/><b>SUGGESTION.PLACEMENT_NOT_FOUND</b> &nbsp; `12001` 
     *
     * @param bannerSuggestionRequestDto 
     * @return [BannerSuggestionResponseDto]
     */
    @POST("advertisements/banners")
    suspend fun suggestionControllerAdvertiseBanners(@Body bannerSuggestionRequestDto: BannerSuggestionRequestDto): Response<BannerSuggestionResponseDto>

    /**
     * 
     * Fetch a personalized product for advertisement.
     * Responses:
     *  - 201: 
     *  - 400: <b>SUGGESTION.INVALID_PLACEMENT_TYPE</b> &nbsp; `12003` 
     *  - 404: <b>SUGGESTION.NO_ACTIVATED_PLACEMENT</b> &nbsp; `12004` <br/><br/><b>SUGGESTION.PLACEMENT_NOT_FOUND</b> &nbsp; `12001` 
     *
     * @param productSuggestionRequestDto 
     * @return [ProductSuggestionResponseDto]
     */
    @POST("advertisements/products")
    suspend fun suggestionControllerAdvertiseProducts(@Body productSuggestionRequestDto: ProductSuggestionRequestDto): Response<ProductSuggestionResponseDto>

    /**
     * 
     * Fetch a personalized banner for recommendation.
     * Responses:
     *  - 201: 
     *  - 400: <b>SUGGESTION.INVALID_PLACEMENT_TYPE</b> &nbsp; `12003` 
     *  - 404: <b>SUGGESTION.NO_ACTIVATED_PLACEMENT</b> &nbsp; `12004` <br/><br/><b>SUGGESTION.PLACEMENT_NOT_FOUND</b> &nbsp; `12001` 
     *
     * @param bannerSuggestionRequestDto 
     * @return [BannerSuggestionResponseDto]
     */
    @POST("recommendations/banners")
    suspend fun suggestionControllerRecommendBanners(@Body bannerSuggestionRequestDto: BannerSuggestionRequestDto): Response<BannerSuggestionResponseDto>

    /**
     * 
     * Fetch a personalized product for recommendation.
     * Responses:
     *  - 201: 
     *  - 400: <b>SUGGESTION.INVALID_PLACEMENT_TYPE</b> &nbsp; `12003` 
     *  - 404: <b>SUGGESTION.NO_ACTIVATED_PLACEMENT</b> &nbsp; `12004` <br/><br/><b>SUGGESTION.PLACEMENT_NOT_FOUND</b> &nbsp; `12001` 
     *
     * @param productSuggestionRequestDto 
     * @return [ProductSuggestionResponseDto]
     */
    @POST("recommendations/products")
    suspend fun suggestionControllerRecommendProducts(@Body productSuggestionRequestDto: ProductSuggestionRequestDto): Response<ProductSuggestionResponseDto>

}
