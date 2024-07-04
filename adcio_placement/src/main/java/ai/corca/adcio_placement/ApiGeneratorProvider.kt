package ai.corca.adcio_placement

import ai.corca.placement.api.SuggestionApi
import org.openapitools.client.infrastructure.ApiClient

private val apiClient = ApiClient()

val suggestionApi = apiClient.createService(SuggestionApi::class.java)
