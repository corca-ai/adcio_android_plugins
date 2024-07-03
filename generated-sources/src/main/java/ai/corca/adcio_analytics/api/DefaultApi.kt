package ai.corca.adcio_analytics.api

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.squareup.moshi.Json


interface DefaultApi {
    /**
     * 
     * 
     * Responses:
     *  - 200: 
     *
     * @return [Unit]
     */
    @GET("")
    suspend fun appControllerGetData(): Response<Unit>

}
