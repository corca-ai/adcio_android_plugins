package ai.corca.adcio_android_plugins.analytics

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.analytics.utils.MockProductListAdapter
import ai.corca.adcio_android_plugins.analytics.utils.getMockProducts
import ai.corca.adcio_android_plugins.databinding.ActivityAnalyticsBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.corcaai.adcio_core.feature.AdcioCore

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnalyticsBinding
    private lateinit var adapter: MockProductListAdapter

    // Background Thread for Purchase Analytics.
    inner class OnPurchaseThread(
        private val orderId: String,
        private val productIdOnStore: String,
        private val amount: Int,
    ) : Thread() {
        override fun run() {
            // Please call this function if the user purchases a specific product.
            // Please also enter the number of products, amount.
            AdcioAnalytics.onPurchase(
                orderId = orderId,
                productIdOnStore = productIdOnStore,
                amount = amount,
            )
        }
    }

    // Background Thread for Purchase Analytics.
    inner class OnClickThread(
        val logOption: AdcioLogOption
    ) : Thread() {
        override fun run() {
            // If the user clicks on a particular product, call this function.
            AdcioAnalytics.onClick(
                option = logOption,
            )
        }
    }

    // Called when a new screen is displayed
    inner class OnAddToCartThread (
        val cartId: String,
        val productIdOnStore: String,
    ) : Thread() {
        override fun run() {
            // This function is called when a new page is created!
            AdcioAnalytics.onAddToCart(
                cartId = cartId,
                productIdOnStore = productIdOnStore,
            )
        }
    }

    // Called when a new screen is displayed
    inner class OnPageViewThread(
        val path: String,
        private val baseUrl: String? = null
    ) : Thread() {
        override fun run() {
            // This function is called when a new page is created!
            AdcioAnalytics.onPageView(
                path = path,
                baseUrl = baseUrl,
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnalyticsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set AdcioDetectorAnalytics
        // If you don't add an option, an error will occur.
        // 'AdcioLogOption(requestId = "", adsetId = "")' is just sample AdcioLogOption!
        // please get AdcioLogOption to adcio_placement's suggest function.
        binding.adcioDetectorFixedView.option = AdcioLogOption(requestId = "", adsetId = "")

        adapter = MockProductListAdapter(
            onClickPurchase = { logOption ->
                OnPurchaseThread(
                    orderId = "ORDER_ID",
                    productIdOnStore = "PRODUCT_ID",
                    amount = 0
                ).start()
            },
            onClickItem = { logOption ->
                OnClickThread(logOption = logOption).start()
            },
            onAddToCart = {
                OnAddToCartThread(
                    cartId = "CART_ID",
                    productIdOnStore = "PRODUCT_ID"
                )
            },
        )

        binding.rvSuggestions.adapter = adapter
        adapter.submitList(getMockProducts())
    }

    override fun onStart() {
        super.onStart()

        // Called every time a new screen is created
        OnPageViewThread(path = "MAIN").start()
    }
}
