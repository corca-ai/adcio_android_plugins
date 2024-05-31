package ai.corca.adcio_android_plugins.suggestion.helper

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_analytics.model.AdcioLogOption

val adcioAnalytics = AdcioAnalytics("67592c00-a230-4c31-902e-82ae4fe71866")

// Background Thread for Impression Analytics
internal class OnImpressionThread(
    private val logOption: AdcioLogOption
): Thread() {
    override fun run() {
        // Called when the item's view is more than 50% exposed
        adcioAnalytics.onImpression(
            option = logOption
        )
    }
}

// Background Thread for Click Analytics.
internal class OnClickThread(
    val logOption: AdcioLogOption
) : Thread() {
    override fun run() {
        // If the user clicks on a particular product, call this function.
        adcioAnalytics.onClick(
            option = logOption,
        )
    }
}

// Background Thread for Purchase Analytics.
internal class OnPurchaseThread(
    private val orderId: String,
    private val productIdOnStore: String,
    private val amount: Int,
) : Thread() {
    override fun run() {
        // Please call this function if the user purchases a specific product.
        // Please also enter the number of products, amount.
        adcioAnalytics.onPurchase(
            orderId = orderId,
            productIdOnStore = productIdOnStore,
            amount = amount,
        )
    }
}

// Called when a new screen is displayed
internal class OnAddToCartThread(
    val productIdOnStore: String,
) : Thread() {
    override fun run() {
        // This function is called when a new page is created!
        adcioAnalytics.onAddToCart(
            productIdOnStore = productIdOnStore,
        )
    }
}

// Log when the customer views a specific product / category page.
internal class OnPageViewThread(
    private val productId: String,
) : Thread() {
    override fun run() {
        // This function is called when a new page is created!
        adcioAnalytics.onPageView(
            productIdOnStore = productId
        )
    }
}