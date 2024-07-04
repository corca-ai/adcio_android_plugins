package ai.corca.adcio_analytics


private val apiClient = ApiClient()

val eventsApi = apiClient.createService(EventsApi::class.java)
