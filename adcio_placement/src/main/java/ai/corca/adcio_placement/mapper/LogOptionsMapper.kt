package ai.corca.adcio_placement.mapper

import ai.corca.adcio_placement.model.banner.BannerLogOptions
import ai.corca.adcio_placement.model.product.ProductLogOptions
import ai.corca.adcio_placement.network.data.response.banner.BannerLogOptionsData
import ai.corca.adcio_placement.network.data.response.product.ProductLogOptionsData

internal fun BannerLogOptionsData.toLogOptions(): BannerLogOptions = BannerLogOptions(
    requestId = this.requestId,
    adsetId = this.adsetId,
)

internal fun BannerLogOptions.toBannerLogOptionsData(): BannerLogOptionsData = BannerLogOptionsData(
    requestId = this.requestId,
    adsetId = this.adsetId,
)

internal fun ProductLogOptionsData.toLogOptions(): ProductLogOptions = ProductLogOptions(
    requestId = this.requestId,
    adsetId = this.adsetId,
)

internal fun ProductLogOptions.toProductLogOptionsData(): ProductLogOptionsData = ProductLogOptionsData(
    requestId = this.requestId,
    adsetId = this.adsetId,
)

