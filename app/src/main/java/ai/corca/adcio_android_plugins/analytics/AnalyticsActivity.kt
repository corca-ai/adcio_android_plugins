package ai.corca.adcio_android_plugins.analytics

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.analytics.utils.MockProductListAdapter
import ai.corca.adcio_android_plugins.analytics.utils.getMockProducts
import ai.corca.adcio_android_plugins.databinding.ActivityAnalyticsBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnalyticsBinding
    private lateinit var adapter: MockProductListAdapter

    // Background Thread for Purchase Analytics.
    inner class OnPurchaseThread(
        val logOption: AdcioLogOption
    ) : Thread() {
        override fun run() {
            // Please call this function if the user purchases a specific product.
            // Please also enter the number of products, amount.
            AdcioAnalytics.onPurchase(
                option = logOption,
                amount = 2,
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
                OnPurchaseThread(logOption = logOption).start()
            },
            onClickItem = { logOption ->
                OnClickThread(logOption = logOption).start()
            }
        )

        binding.rvSuggestions.adapter = adapter
        adapter.submitList(getMockProducts())
    }
}
