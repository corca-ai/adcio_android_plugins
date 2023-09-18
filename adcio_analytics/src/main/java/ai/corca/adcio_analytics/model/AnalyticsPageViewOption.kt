package ai.corca.adcio_analytics.model

import com.corcaai.adcio_core.feature.AdcioCore

data class AnalyticsPageViewOption(
    val sessionId: String = AdcioCore.sessionId,
    val deviceId: String = AdcioCore.deviceId!!,
    val customerId: String? = null,
    val storeId: String = AdcioCore.storeId!!,
    val productCode: String? = null,
    val path: String,
    val title: String? = null,
    val referrer: String? = null,
)
