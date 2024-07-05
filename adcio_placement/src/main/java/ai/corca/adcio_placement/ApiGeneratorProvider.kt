package ai.corca.adcio_placement

import ai.corca.generator_placement.api.SuggestionApi
import ai.corca.generator_placement.infrastructure.ApiClient

private val apiClient = ApiClient()

val suggestionApi = apiClient.createService(SuggestionApi::class.java)
