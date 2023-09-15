package ai.corca.adcio_analytics.mapper

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_analytics.model.AnalyticsPageViewOption
import ai.corca.adcio_analytics.network.data.AnalyticsRequest
import ai.corca.adcio_analytics.network.data.pageview.AnalyticsPageViewRequest

internal fun AnalyticsRequest.toLogOption(): AdcioLogOption = AdcioLogOption(
    requestId = this.requestId,
    adsetId = this.adsetId,
)

internal fun AdcioLogOption.toAnalyticsRequest(
    amount: Int? = null
): AnalyticsRequest = AnalyticsRequest(
    requestId = this.requestId,
    adsetId = this.adsetId,
    amount = amount,
)

internal fun AnalyticsPageViewOption.toAnalyticsPageViewRequest(): AnalyticsPageViewRequest =
    AnalyticsPageViewRequest(
        sessionId = this.sessionId,
        deviceId = this.deviceId,
        customerId = this.customerId,
        storeId = this.storeId,
        productCode = this.productCode,
        path = this.path,
        title = this.title ?: this.path,
        referrer = this.referrer,
    )
