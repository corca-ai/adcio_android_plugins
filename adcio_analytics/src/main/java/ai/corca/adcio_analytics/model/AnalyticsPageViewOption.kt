package ai.corca.adcio_analytics.model

import com.corcaai.core.ids.SessionClient
import com.corcaai.core.ids.loadDeviceId

data class AnalyticsPageViewOption(
    val sessionId: String = SessionClient.loadSessionId(),
    val deviceId: String = loadDeviceId(),
    val customerId: String? = null,
    val storeId: String? = null,
    val productCode: String? = null,
    val path: String,
    val title: String? = null,
    val referrer: String? = null,
)
