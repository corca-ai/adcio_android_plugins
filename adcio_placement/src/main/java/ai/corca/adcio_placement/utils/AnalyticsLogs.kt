package ai.corca.adcio_placement.utils

import ai.corca.adcio_placement.exception.PlatformException

internal const val TRACE_EXCEPTION_TAG = "AdcioPlacementException"

internal fun PlatformException.toNetworkErrorLog(): String =
    "errorCode: $code\nerrorMessage: $errorMessage"
