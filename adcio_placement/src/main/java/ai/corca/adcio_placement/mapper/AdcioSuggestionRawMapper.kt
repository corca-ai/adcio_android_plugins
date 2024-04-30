package ai.corca.adcio_placement.mapper

import ai.corca.adcio_placement.model.banner.AdcioSuggestionBannerRaw
import ai.corca.adcio_placement.model.product.AdcioSuggestionProductRaw
import ai.corca.adcio_placement.network.data.response.banner.AdcioSuggestionBannerRawData
import ai.corca.adcio_placement.network.data.response.product.AdcioSuggestionProductRawData

internal fun AdcioSuggestionBannerRawData.toAdcioSuggestionBannerRaw(): AdcioSuggestionBannerRaw = AdcioSuggestionBannerRaw(
    suggestions = this.suggestionDataList.map { it.toAdcioSuggestionBanner() }
)

internal fun AdcioSuggestionProductRawData.toAdcioSuggestionRawData(): AdcioSuggestionProductRaw =
    AdcioSuggestionProductRaw(
        suggestions = this.suggestionDataList.map { it.toAdcioSuggestionProduct() }
    )
