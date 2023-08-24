package ai.corca.adcio_analytics.mapper

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.network.data.AnalyticsRequest

internal fun AnalyticsRequest.toLogOption(): AdcioLogOption = AdcioLogOption(
    requestId = this.requestId,
    adsetId = this.adsetId,
)

internal fun AdcioLogOption.toAnalyticsRequest(): AnalyticsRequest = AnalyticsRequest(
    requestId = this.requestId,
    adsetId = this.adsetId,
)
