package ai.corca.adcio_android_plugins.analytics.utils

import ai.corca.adcio_analytics.model.AdcioLogOption

data class MockProduct(
    val id: String,
    val name: String,
    val price: Int,
    val image: String,
    val logOption: AdcioLogOption,
)

fun getMockProducts(): List<MockProduct> = listOf(
    MockProduct(
        id = "1",
        name = "Product 1",
        price = 10000,
        image = "https://picsum.photos/200/300",
        logOption = AdcioLogOption(requestId = "2023081805292275799", adsetId = "1"),
    ),
    MockProduct(
        id = "2",
        name = "Product 2",
        price = 12000,
        image = "https://picsum.photos/200/200",
        logOption = AdcioLogOption(requestId = "2023081805292275799", adsetId = "2"),
    ),
    MockProduct(
        id = "3",
        name = "Product 3",
        price = 13000,
        image = "https://picsum.photos/300/300",
        logOption = AdcioLogOption(requestId = "2023081805292275799", adsetId = "3"),
    ),
)
