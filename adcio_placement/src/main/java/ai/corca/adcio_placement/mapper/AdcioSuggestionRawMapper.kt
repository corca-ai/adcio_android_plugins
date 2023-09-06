package ai.corca.adcio_placement.mapper

import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.data.AdcioSuggestionRawData

internal fun AdcioSuggestionRawData.toAdcioSuggestionRaw(): AdcioSuggestionRaw = AdcioSuggestionRaw(
    placement = this.placementData.toPlacement(),
    suggestions = this.suggestionDataList.map { it.toAdcioSuggestion() }
)

internal fun AdcioSuggestionRaw.toAdcioSuggestionRawData(): AdcioSuggestionRawData =
    AdcioSuggestionRawData(
        placementData = this.placement.toPlacementData(),
        suggestionDataList = this.suggestions.map { it.toAdcioSuggestionData() }
    )
