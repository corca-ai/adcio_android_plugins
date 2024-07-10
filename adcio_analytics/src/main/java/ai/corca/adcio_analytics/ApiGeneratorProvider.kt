package ai.corca.adcio_analytics

import ai.corca.generator_analytics.api.EventsApi
import ai.corca.generator_analytics.infrastructure.ApiClient


val apiClient = ApiClient().apply {
    setLogger { message -> println(message) }
}

val eventsApi = apiClient.createService(EventsApi::class.java)
