package ai.corca.adcio_placement

import ai.corca.generator_placement.api.SuggestionApi
import ai.corca.generator_placement.infrastructure.ApiClient

private val apiClient = ApiClient().apply {
    setLogger { message -> println(message) } // 로거 설정
}

val suggestionApi = apiClient.createService(SuggestionApi::class.java)
