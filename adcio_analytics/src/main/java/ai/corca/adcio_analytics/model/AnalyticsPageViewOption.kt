package ai.corca.adcio_analytics.model

import com.corcaai.adcio_core.feature.AdcioInfo

data class AnalyticsPageViewOption(
    val sessionId: String = AdcioInfo.sessionId,
    val deviceId: String = AdcioInfo.deviceId!!,
    val customerId: String? = null,
    val storeId: String = AdcioInfo.storeId!!,
    val productCode: String? = null,
    val path: String,
    val title: String? = null,
    val referrer: String? = null,
)
