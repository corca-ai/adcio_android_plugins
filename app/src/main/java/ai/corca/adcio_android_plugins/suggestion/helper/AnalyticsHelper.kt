package ai.corca.adcio_android_plugins.suggestion.helper

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.suggestion.adcioAnalytics
import android.os.Build


// Background Thread for Impression Analytics
internal class OnImpressionThread(
    private val logOption: AdcioLogOption
): Thread() {
    override fun run() {
        // Called when a product recommended as a suggestion has at least 50% exposure on the screen for at least 1 second.
        adcioAnalytics.onImpression(
            option = logOption,
            customerId = null,
            userAgent = "${Build.MODEL} - ${Build.VERSION.RELEASE}" // Example OS Version
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
            customerId = null,
            productIdOnStore = null,
            userAgent = "${Build.MODEL} - ${Build.VERSION.RELEASE}" // Example OS Version
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
            categoryIdOnStore = null,
            amount = amount,
            customerId = null,
            option = null,
            quantity = null,
            userAgent = "${Build.MODEL} - ${Build.VERSION.RELEASE}" // Example OS Version
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
            customerId = null,
            categoryIdOnStore = null,
            cartId = null,
            option = null,
            quantity = null,
            userAgent = "${Build.MODEL} - ${Build.VERSION.RELEASE}" // Example OS Version
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
            productIdOnStore = productId,
            categoryIdOnStore = null,
            option = null,
            customerId = null,
            userAgent = "${Build.MODEL} - ${Build.VERSION.RELEASE}" // Example OS Version
        )
    }
}