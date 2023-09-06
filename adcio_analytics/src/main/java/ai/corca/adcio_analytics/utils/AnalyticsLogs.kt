package ai.corca.adcio_analytics.utils

import ai.corca.adcio_analytics.exception.PlatformException

internal const val TRACE_EXCEPTION_TAG = "AdcioAnalyticsException"

internal fun PlatformException.toNetworkErrorLog(): String =
    "errorCode: $code\nerrorMessage: $errorMessage"
