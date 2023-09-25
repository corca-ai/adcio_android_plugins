package ai.corca.adcio_analytics

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_analytics.model.AdcioLogOption
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.corcaai.adcio_core.feature.AdcioCore
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AnalyticsTest {

    @Before
    fun initBeforeTest() {
        AdcioCore.initializeApp("")
    }

    @Test
    fun testOnImpression() {
        AdcioAnalytics.onImpression(
            option = AdcioLogOption(
                requestId = "",
                adsetId = ""
            ),
            baseUrl = "https://receiver-dev.adcio.ai/"
        )
    }

    @Test
    fun testOnClick() {
        AdcioAnalytics.onClick(
            option = AdcioLogOption(
                requestId = "",
                adsetId = "",
            ),
            baseUrl = "https://receiver-dev.adcio.ai/"
        )
    }

    @Test
    fun testOnPurchase() {
        AdcioAnalytics.onPurchase(
            orderId = "",
            productIdOnStore = "",
            amount = 0,
            baseUrl = "https://receiver-dev.adcio.ai/"
        )
    }

    @Test
    fun testOnPageView() {
        AdcioAnalytics.onPageView(
            path = "",
            baseUrl = "https://receiver-dev.adcio.ai/"
        )
    }

    @Test
    fun testOnAddToCart() {
        AdcioAnalytics.onAddToCart(
            cartId = "",
            productIdOnStore = "",
            baseUrl = "https://receiver-dev.adcio.ai/"
        )
    }
}
