package ai.corca.adcio_placement.api

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.squareup.moshi.Json

import ai.corca.adcio_placement.model.CreateProductDto
import ai.corca.adcio_placement.model.FetchProductResponseDto
import ai.corca.adcio_placement.model.NestJSErrorSchema
import ai.corca.adcio_placement.model.Product
import ai.corca.adcio_placement.model.ProductControllerFetchMany200Response
import ai.corca.adcio_placement.model.UpdateProductDto
import ai.corca.adcio_placement.model.UpsertManyProductDto
import ai.corca.adcio_placement.model.UpsertManyProductResponseDto

interface ProductApi {
    /**
     * 
     * 
     * Responses:
     *  - 201: 
     *  - 400: <b>COMMON.INVALID_URL</b> &nbsp; `10008` <br/><br/><b>PRODUCT.SELLER_DOES_NOT_EXISTS_ON_STORES_SELLER</b> &nbsp; `19001` 
     *  - 401: 
     *  - 409: <b>PRODUCT.PRODUCT_CODE_OF_THE_STORE_ALREADY_EXIST</b> &nbsp; `19004` 
     *
     * @param createProductDto 
     * @return [Product]
     */
    @POST("products")
    suspend fun productControllerCreate(@Body createProductDto: CreateProductDto): Response<Product>

    /**
     * 
     * Fetch many products.
     * Responses:
     *  - 200: 
     *  - 400: <b>COMMON.PAGINATION_LIMIT_TOO_LARGE</b> &nbsp; `10015` 
     *  - 401: 
     *
     * @param orderBy ProductSortOption (optional)
     * @param sellerId  (optional)
     * @param storeId  (optional)
     * @param startDate  (optional)
     * @param endDate  (optional)
     * @param placementId  (optional)
     * @param categoryId  (optional)
     * @param activated  (optional)
     * @param name  (optional)
     * @param idOnStore  (optional)
     * @param limit  (optional)
     * @param offset  (optional)
     * @return [ProductControllerFetchMany200Response]
     */
    @GET("products")
    suspend fun productControllerFetchMany(@Query("orderBy") orderBy: kotlin.collections.List<kotlin.String>? = null, @Query("sellerId") sellerId: kotlin.String? = null, @Query("storeId") storeId: kotlin.String? = null, @Query("startDate") startDate: java.time.OffsetDateTime? = null, @Query("endDate") endDate: java.time.OffsetDateTime? = null, @Query("placementId") placementId: kotlin.String? = null, @Query("categoryId") categoryId: kotlin.String? = null, @Query("activated") activated: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("idOnStore") idOnStore: kotlin.String? = null, @Query("limit") limit: java.math.BigDecimal? = null, @Query("offset") offset: java.math.BigDecimal? = null): Response<ProductControllerFetchMany200Response>

    /**
     * 
     * Fetch one product.
     * Responses:
     *  - 200: 
     *
     * @param id 
     * @return [FetchProductResponseDto]
     */
    @GET("products/{id}")
    suspend fun productControllerFetchOne(@Path("id") id: kotlin.String): Response<FetchProductResponseDto>

    /**
     * 
     * 
     * Responses:
     *  - 204: 
     *  - 400: <b>COMMON.INVALID_URL</b> &nbsp; `10008` 
     *  - 401: 
     *  - 404: <b>PRODUCT.PRODUCT_NOT_FOUND</b> &nbsp; `19002` 
     *  - 409: <b>PRODUCT.PRODUCT_CODE_OF_THE_STORE_ALREADY_EXIST</b> &nbsp; `19004` 
     *
     * @param id 
     * @param updateProductDto 
     * @return [Unit]
     */
    @PATCH("products/{id}")
    suspend fun productControllerUpdate(@Path("id") id: kotlin.String, @Body updateProductDto: UpdateProductDto): Response<Unit>

    /**
     * 
     * Bulk upsert products.
     * Responses:
     *  - 200: 
     *
     * @param upsertManyProductDto 
     * @return [UpsertManyProductResponseDto]
     */
    @PUT("products/bulk")
    suspend fun productControllerUpsertMany(@Body upsertManyProductDto: UpsertManyProductDto): Response<UpsertManyProductResponseDto>

}
