package ai.corca.adcio_analytics

import ai.corca.adcio_analytics.api.EventsApi
import org.openapitools.client.infrastructure.ApiClient

private val apiClient = ApiClient()

val eventsApi = apiClient.createService(EventsApi::class.java)