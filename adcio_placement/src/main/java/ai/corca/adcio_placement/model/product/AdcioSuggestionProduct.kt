package ai.corca.adcio_placement.model.product

import ai.corca.adcio_placement.model.MetaData

data class AdcioSuggestionProduct(
    val logOptions: ProductLogOptions,
    val product: Product,
)
