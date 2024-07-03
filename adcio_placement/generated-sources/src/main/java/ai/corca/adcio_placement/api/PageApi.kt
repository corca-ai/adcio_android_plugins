package ai.corca.adcio_placement.api

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.squareup.moshi.Json

import ai.corca.adcio_placement.model.FetchActivePlacementsResponseDto

interface PageApi {
    /**
     * 
     * Fetch active placements of the page.
     * Responses:
     *  - 200: 
     *
     * @param name 
     * @param clientId The client ID of the placement owner.
     * @return [kotlin.collections.List<FetchActivePlacementsResponseDto>]
     */
    @GET("pages/{name}/placements")
    suspend fun pageControllerFetchActivePlacements(@Path("name") name: kotlin.String, @Query("clientId") clientId: kotlin.String): Response<kotlin.collections.List<FetchActivePlacementsResponseDto>>

}
