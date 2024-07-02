package ai.corca.adcio_placement.model.banner

import ai.corca.adcio_placement.model.MetaData

data class AdcioSuggestionBanner(
    val banner: Banner?,
    val logOptions: BannerLogOptions,
    val metaData: MetaData
)



