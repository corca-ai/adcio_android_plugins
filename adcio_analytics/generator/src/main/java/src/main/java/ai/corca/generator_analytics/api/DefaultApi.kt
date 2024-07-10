package ai.corca.generator_analytics.api

import ai.corca.generator_analytics.infrastructure.CollectionFormats.*
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
