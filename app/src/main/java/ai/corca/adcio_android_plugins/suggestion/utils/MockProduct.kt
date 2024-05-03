package ai.corca.adcio_android_plugins.suggestion.utils

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.suggestion.model.Production

fun getMockProducts(): List<Production> = listOf(
    Production(
        productId = "1",
        name = "Product 1",
        price = "10000",
        image = "https://picsum.photos/200/300",
        logOption = AdcioLogOption(requestId = "2023081805292275799", adsetId = "1"),
        isSuggested = false
    ),
    Production(
        productId = "2",
        name = "Product 2",
        price = "12000",
        image = "https://picsum.photos/200/200",
        logOption = AdcioLogOption(requestId = "2023081805292275799", adsetId = "2"),
        isSuggested = false
    ),
    Production(
        productId = "3",
        name = "Product 3",
        price = "13000",
        image = "https://picsum.photos/300/300",
        logOption = AdcioLogOption(requestId = "2023081805292275799", adsetId = "3"),
        isSuggested = false
    ),
)
