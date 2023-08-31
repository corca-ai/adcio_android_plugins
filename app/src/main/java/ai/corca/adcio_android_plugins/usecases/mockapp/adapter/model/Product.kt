package ai.corca.adcio_android_plugins.usecases.mockapp.adapter.model

import ai.corca.adcio_analytics.model.AdcioLogOption

data class Product(
    val productId: String,
    val isAd: Boolean,
    val name: String,
    val image: String,
    val brand: String,
    val sale: String,
    val price: String,
    val logOption: AdcioLogOption? = null,
)
