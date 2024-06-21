package ai.corca.adcio_placement.model.product

import ai.corca.adcio_placement.model.MetaData

data class AdcioSuggestionProductRaw(
    val suggestions: List<AdcioSuggestionProduct>,
    val metaData: MetaData
)
