package ai.corca.adcio_analytics

import ai.corca.analytics.api.EventsApi
import ai.corca.analytics.infrastructure.ApiClient


private val apiClient = ApiClient()

val eventsApi = apiClient.createService(EventsApi::class.java)
