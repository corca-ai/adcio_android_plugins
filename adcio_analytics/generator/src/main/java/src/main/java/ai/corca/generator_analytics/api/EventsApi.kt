package ai.corca.generator_analytics.api

import ai.corca.generator_analytics.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.squareup.moshi.Json

import ai.corca.generator_analytics.model.NestJSErrorSchema
import ai.corca.generator_analytics.model.TrackAddToCartRequestDto
import ai.corca.generator_analytics.model.TrackClickRequestDto
import ai.corca.generator_analytics.model.TrackImpressionRequestDto
import ai.corca.generator_analytics.model.TrackPageViewRequestDto
import ai.corca.generator_analytics.model.TrackPurchaseRequestDto
import ai.corca.generator_analytics.model.TrackResponseDto

interface EventsApi {
    /**
     * 
     * Log when the customer adds a product to the cart.
     * Responses:
     *  - 201: 
     *  - 400: 
     *  - 500: 
     *
     * @param trackAddToCartRequestDto 
     * @return [TrackResponseDto]
     */
    @POST("events/add-to-cart")
    suspend fun eventsControllerOnAddToCart(@Body trackAddToCartRequestDto: TrackAddToCartRequestDto): Response<TrackResponseDto>

    /**
     * 
     * Log a click.
     * Responses:
     *  - 201: 
     *  - 400: 
     *  - 500: 
     *
     * @param trackClickRequestDto 
     * @return [TrackResponseDto]
     */
    @POST("events/click")
    suspend fun eventsControllerOnClick(@Body trackClickRequestDto: TrackClickRequestDto): Response<TrackResponseDto>

    /**
     * 
     * Log an impression.
     * Responses:
     *  - 201: 
     *  - 400: 
     *  - 500: 
     *
     * @param trackImpressionRequestDto 
     * @return [TrackResponseDto]
     */
    @POST("events/impression")
    suspend fun eventsControllerOnImpression(@Body trackImpressionRequestDto: TrackImpressionRequestDto): Response<TrackResponseDto>

    /**
     * 
     * Log when the customer views a specific product / category page.
     * Responses:
     *  - 201: 
     *  - 400: 
     *  - 500: 
     *
     * @param trackPageViewRequestDto 
     * @return [TrackResponseDto]
     */
    @POST("events/view")
    suspend fun eventsControllerOnPageView(@Body trackPageViewRequestDto: TrackPageViewRequestDto): Response<TrackResponseDto>

    /**
     * 
     * Log when the customer purchases a product.
     * Responses:
     *  - 201: 
     *  - 400: 
     *  - 500: 
     *
     * @param trackPurchaseRequestDto 
     * @return [TrackResponseDto]
     */
    @POST("events/purchase")
    suspend fun eventsControllerOnPurchase(@Body trackPurchaseRequestDto: TrackPurchaseRequestDto): Response<TrackResponseDto>

}
