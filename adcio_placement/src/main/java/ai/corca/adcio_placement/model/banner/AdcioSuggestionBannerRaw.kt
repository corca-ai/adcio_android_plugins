package ai.corca.adcio_placement.model.banner

import ai.corca.adcio_placement.model.MetaData

data class AdcioSuggestionBannerRaw(
    val suggestions: List<AdcioSuggestionBanner>,
    val metaData: MetaData
)
