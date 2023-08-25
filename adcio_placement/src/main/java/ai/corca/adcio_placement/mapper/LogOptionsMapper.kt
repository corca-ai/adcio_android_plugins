package ai.corca.adcio_placement.mapper

import ai.corca.adcio_placement.model.LogOptions
import ai.corca.adcio_placement.network.data.LogOptionsData

internal fun LogOptionsData.toLogOptions(): LogOptions = LogOptions(
    requestId = this.requestId,
    adsetId = this.adsetId,
)

internal fun LogOptions.toLogOptionsData(): LogOptionsData = LogOptionsData(
    requestId = this.requestId,
    adsetId = this.adsetId,
)
