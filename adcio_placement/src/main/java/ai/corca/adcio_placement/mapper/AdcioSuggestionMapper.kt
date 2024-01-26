package ai.corca.adcio_placement.mapper

import ai.corca.adcio_placement.model.AdcioSuggestion
import ai.corca.adcio_placement.network.data.AdcioSuggestionData

internal fun AdcioSuggestion.toAdcioSuggestionData(): AdcioSuggestionData = AdcioSuggestionData(
    bannerData = this.banner?.toBannerData(),
    logOptionsData = this.logOptions.toLogOptionsData(),
    productData = this.product.toProductData()
)

internal fun AdcioSuggestionData.toAdcioSuggestion(): AdcioSuggestion = AdcioSuggestion(
    banner = this.bannerData?.toBanner(),
    logOptions = this.logOptionsData.toLogOptions(),
    product = this.productData.toProduct()
)
