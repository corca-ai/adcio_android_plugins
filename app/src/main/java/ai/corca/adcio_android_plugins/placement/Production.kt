package ai.corca.adcio_android_plugins.placement

import ai.corca.adcio_analytics.model.AdcioLogOption

data class Production(
    val productId: String,
    val name: String,
    val image: String,
    val price: String,
    val logOption: AdcioLogOption,
)
