package ai.corca.adcio_placement.api

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.squareup.moshi.Json

import ai.corca.adcio_placement.model.Banner
import ai.corca.adcio_placement.model.BannerControllerFetchMany200Response
import ai.corca.adcio_placement.model.CreateBannerDto
import ai.corca.adcio_placement.model.FetchBannerResponseDto
import ai.corca.adcio_placement.model.NestJSErrorSchema
import ai.corca.adcio_placement.model.UpdateBannerDto

interface BannerApi {
    /**
     * 
     * 
     * Responses:
     *  - 201: 
     *  - 400: <b>COMMON.INVALID_URL</b> &nbsp; `10008` <br/><br/><b>COMMON.START_DATE_MUST_BE_BEFORE_END_DATE</b> &nbsp; `10016` <br/><br/><b>BANNER.LINK_PRODUCT_OR_CATEGORY_FAILED</b> &nbsp; `27005` 
     *  - 401: 
     *  - 404: <b>BANNER.CLIENT_NOT_FOUND</b> &nbsp; `27002` 
     *  - 409: <b>BANNER.BANNER_NAME_DUPLICATED</b> &nbsp; `27003` 
     *
     * @param createBannerDto 
     * @return [Banner]
     */
    @POST("banners")
    suspend fun bannerControllerCreate(@Body createBannerDto: CreateBannerDto): Response<Banner>

    /**
     * 
     * 
     * Responses:
     *  - 200: 
     *  - 401: 
     *  - 404: <b>BANNER.BANNER_NOT_FOUND</b> &nbsp; `27001` 
     *
     * @param id 
     * @return [Unit]
     */
    @DELETE("banners/{id}")
    suspend fun bannerControllerDelete(@Path("id") id: kotlin.String): Response<Unit>


    /**
    * enum for parameter select
    */
    enum class Select_bannerControllerFetchMany(val value: kotlin.String) {
        @Json(name = "id") id("id"),
        @Json(name = "name") name("name"),
        @Json(name = "imageUrl") imageUrl("imageUrl"),
        @Json(name = "url") url("url"),
        @Json(name = "data") `data`("data"),
        @Json(name = "activated") activated("activated"),
        @Json(name = "startsAt") startsAt("startsAt"),
        @Json(name = "endsAt") endsAt("endsAt"),
        @Json(name = "createdAt") createdAt("createdAt")
    }


    /**
    * enum for parameter type
    */
    enum class Type_bannerControllerFetchMany(val value: kotlin.String) {
        @Json(name = "video") video("video"),
        @Json(name = "image") image("image")
    }

    /**
     * 
     * 
     * Responses:
     *  - 200: 
     *  - 400: <b>COMMON.PAGINATION_LIMIT_TOO_LARGE</b> &nbsp; `10015` 
     *  - 401: 
     *
     * @param orderBy BannerSortOption (optional)
     * @param select  (optional)
     * @param activated  (optional)
     * @param name  (optional)
     * @param placementIds  (optional)
     * @param type  (optional)
     * @param startsAt  (optional)
     * @param endsAt  (optional)
     * @param limit  (optional)
     * @param offset  (optional)
     * @return [BannerControllerFetchMany200Response]
     */
    @GET("banners")
    suspend fun bannerControllerFetchMany(@Query("orderBy") orderBy: kotlin.collections.List<kotlin.String>? = null, @Query("select") select: kotlin.collections.List<kotlin.String>? = null, @Query("activated") activated: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("placementIds") placementIds: kotlin.collections.List<kotlin.String>? = null, @Query("type") type: Type_bannerControllerFetchMany? = null, @Query("startsAt") startsAt: java.time.OffsetDateTime? = null, @Query("endsAt") endsAt: java.time.OffsetDateTime? = null, @Query("limit") limit: java.math.BigDecimal? = null, @Query("offset") offset: java.math.BigDecimal? = null): Response<BannerControllerFetchMany200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: 
     *  - 401: 
     *  - 404: <b>BANNER.BANNER_NOT_FOUND</b> &nbsp; `27001` 
     *
     * @param id 
     * @return [FetchBannerResponseDto]
     */
    @GET("banners/{id}")
    suspend fun bannerControllerFetchOne(@Path("id") id: kotlin.String): Response<FetchBannerResponseDto>

    /**
     * 
     * 
     * Responses:
     *  - 200: 
     *  - 400: <b>COMMON.INVALID_URL</b> &nbsp; `10008` <br/><br/><b>COMMON.START_DATE_MUST_BE_BEFORE_END_DATE</b> &nbsp; `10016` <br/><br/><b>BANNER.LINK_PRODUCT_OR_CATEGORY_FAILED</b> &nbsp; `27005` 
     *  - 401: 
     *  - 404: <b>BANNER.BANNER_NOT_FOUND</b> &nbsp; `27001` 
     *  - 409: <b>BANNER.BANNER_NAME_DUPLICATED</b> &nbsp; `27003` 
     *
     * @param id 
     * @param updateBannerDto 
     * @return [Banner]
     */
    @PUT("banners/{id}")
    suspend fun bannerControllerUpdate(@Path("id") id: kotlin.String, @Body updateBannerDto: UpdateBannerDto): Response<Banner>

}
