package ai.corca.placement.api

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.squareup.moshi.Json

import ai.corca.placement.model.ConnectProductsToPlacementDto
import ai.corca.placement.model.ConnectProductsToPlacementResponseDto
import ai.corca.placement.model.CreatePlacementDto
import ai.corca.placement.model.FetchPlacementResponseDto
import ai.corca.placement.model.NestJSErrorSchema
import ai.corca.placement.model.Placement
import ai.corca.placement.model.PlacementControllerFetchMany200Response
import ai.corca.placement.model.RemoveProductFromPlacementResponseDto
import ai.corca.placement.model.UpdatePlacementDto
import ai.corca.placement.model.UpdatePlacementResponseDto

interface PlacementApi {
    /**
     * 
     * 
     * Responses:
     *  - 201: 
     *  - 400: <b>PLACEMENT.PLACEMENT_NOT_FOUND</b> &nbsp; `21001` 
     *  - 401: 
     *
     * @param id 
     * @param connectProductsToPlacementDto 
     * @return [ConnectProductsToPlacementResponseDto]
     */
    @POST("placements/{id}/products")
    suspend fun placementControllerConnectProducts(@Path("id") id: kotlin.String, @Body connectProductsToPlacementDto: ConnectProductsToPlacementDto): Response<ConnectProductsToPlacementResponseDto>

    /**
     * 
     * 
     * Responses:
     *  - 201: 
     *  - 400: <b>PLACEMENT.INVALID_DISPLAY_COUNT</b> &nbsp; `21012` <br/><br/><b>PLACEMENT.INVALID_PLACEMENT_FORMAT</b> &nbsp; `21013` <br/><br/><b>PLACEMENT.CLIENT_NOT_FOUND</b> &nbsp; `21006` <br/><br/><b>PLACEMENT.INVALID_BANNER_PLACEMENT_TYPE</b> &nbsp; `21016` 
     *  - 401: 
     *
     * @param createPlacementDto 
     * @return [Placement]
     */
    @POST("placements")
    suspend fun placementControllerCreate(@Body createPlacementDto: CreatePlacementDto): Response<Placement>


    /**
    * enum for parameter select
    */
    enum class Select_placementControllerFetchMany(val value: kotlin.String) {
        @Json(name = "id") id("id"),
        @Json(name = "title") title("title"),
        @Json(name = "type") type("type"),
        @Json(name = "suggestionType") suggestionType("suggestionType"),
        @Json(name = "displayCount") displayCount("displayCount"),
        @Json(name = "activated") activated("activated"),
        @Json(name = "pageName") pageName("pageName"),
        @Json(name = "clientId") clientId("clientId"),
        @Json(name = "injector") injector("injector"),
        @Json(name = "screenShot") screenShot("screenShot"),
        @Json(name = "displayFormatWidth") displayFormatWidth("displayFormatWidth"),
        @Json(name = "displayFormatHeight") displayFormatHeight("displayFormatHeight"),
        @Json(name = "property") `property`("property"),
        @Json(name = "placementFormatRatio") placementFormatRatio("placementFormatRatio"),
        @Json(name = "createdAt") createdAt("createdAt"),
        @Json(name = "updatedAt") updatedAt("updatedAt"),
        @Json(name = "deletedAt") deletedAt("deletedAt")
    }


    /**
    * enum for parameter type
    */
    enum class Type_placementControllerFetchMany(val value: kotlin.String) {
        @Json(name = "GRID") gRID("GRID"),
        @Json(name = "BANNER") bANNER("BANNER")
    }


    /**
    * enum for parameter suggestionType
    */
    enum class SuggestionType_placementControllerFetchMany(val value: kotlin.String) {
        @Json(name = "RECOMMEND") rECOMMEND("RECOMMEND"),
        @Json(name = "ADVERTISE") aDVERTISE("ADVERTISE")
    }

    /**
     * 
     * 
     * Responses:
     *  - 200: 
     *  - 400: <b>COMMON.PAGINATION_LIMIT_TOO_LARGE</b> &nbsp; `10015` <br/><br/><b>COMMON.INVALID_URL</b> &nbsp; `10008` 
     *  - 401: 
     *
     * @param orderBy PlacementSortOption (optional)
     * @param select  (optional)
     * @param title  (optional)
     * @param startDate  (optional)
     * @param endDate  (optional)
     * @param type  (optional)
     * @param suggestionType  (optional)
     * @param activated  (optional)
     * @param limit  (optional)
     * @param offset  (optional)
     * @return [PlacementControllerFetchMany200Response]
     */
    @GET("placements")
    suspend fun placementControllerFetchMany(@Query("orderBy") orderBy: kotlin.collections.List<kotlin.String>? = null, @Query("select") select: kotlin.collections.List<kotlin.String>? = null, @Query("title") title: kotlin.String? = null, @Query("startDate") startDate: java.time.OffsetDateTime? = null, @Query("endDate") endDate: java.time.OffsetDateTime? = null, @Query("type") type: Type_placementControllerFetchMany? = null, @Query("suggestionType") suggestionType: SuggestionType_placementControllerFetchMany? = null, @Query("activated") activated: kotlin.Boolean? = null, @Query("limit") limit: java.math.BigDecimal? = null, @Query("offset") offset: java.math.BigDecimal? = null): Response<PlacementControllerFetchMany200Response>

    /**
     * 
     * 
     * Responses:
     *  - 200: 
     *  - 401: 
     *  - 404: <b>PLACEMENT.PLACEMENT_NOT_FOUND</b> &nbsp; `21001` 
     *
     * @param id 
     * @return [FetchPlacementResponseDto]
     */
    @GET("placements/{id}")
    suspend fun placementControllerFetchOne(@Path("id") id: kotlin.String): Response<FetchPlacementResponseDto>

    /**
     * 
     * 
     * Responses:
     *  - 200: 
     *  - 401: 
     *  - 404: <b>PLACEMENT.PLACEMENT_NOT_FOUND</b> &nbsp; `21001` 
     *  - 500: <b>PLACEMENT.DELETE_PLACEMENT_FAILED</b> &nbsp; `21009` 
     *
     * @param id 
     * @return [Unit]
     */
    @DELETE("placements/{id}")
    suspend fun placementControllerRemove(@Path("id") id: kotlin.String): Response<Unit>

    /**
     * 
     * 
     * Responses:
     *  - 200: 
     *  - 401: 
     *  - 404: <b>PLACEMENT.PLACEMENT_NOT_FOUND</b> &nbsp; `21001` <br/><br/><b>PLACEMENT.PRODUCT_NOT_FOUND</b> &nbsp; `21015` 
     *
     * @param id 
     * @param productId 
     * @return [RemoveProductFromPlacementResponseDto]
     */
    @DELETE("placements/{id}/products/{productId}")
    suspend fun placementControllerRemoveProduct(@Path("id") id: kotlin.String, @Path("productId") productId: kotlin.String): Response<RemoveProductFromPlacementResponseDto>

    /**
     * 
     * 
     * Responses:
     *  - 200: 
     *  - 400: <b>PLACEMENT.INVALID_DISPLAY_COUNT</b> &nbsp; `21012` <br/><br/><b>PLACEMENT.TOO_FEW_CONNECTED_ADSETS</b> &nbsp; `21014` 
     *  - 401: 
     *  - 404: <b>PLACEMENT.PLACEMENT_NOT_FOUND</b> &nbsp; `21001` 
     *
     * @param id 
     * @param updatePlacementDto 
     * @return [UpdatePlacementResponseDto]
     */
    @PATCH("placements/{id}")
    suspend fun placementControllerUpdate(@Path("id") id: kotlin.String, @Body updatePlacementDto: UpdatePlacementDto): Response<UpdatePlacementResponseDto>

}
