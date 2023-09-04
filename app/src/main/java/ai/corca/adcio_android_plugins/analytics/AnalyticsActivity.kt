package ai.corca.adcio_android_plugins.analytics

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.analytics.utils.AnalyticsProductionListAdapter
import ai.corca.adcio_android_plugins.databinding.ActivityAnalyticsBinding
import ai.corca.adcio_android_plugins.placement.utils.Production
import ai.corca.adcio_placement.feature.AdcioPlacement
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnalyticsBinding
    private lateinit var adapter: AnalyticsProductionListAdapter
    private var productions: MutableList<Production> = emptyList<Production>().toMutableList()

    // Background Thread for getSuggestions.
    inner class GetSuggestionThread : Thread() {
        override fun run() {
            // Call AdcioPlacement.adcioSuggestion(placementId, baseUrl) function to get ADCIO suggestion Data
            // You can receive SuggestionRaw entity.
            // Mind your own business with the data you received!
            val suggestionRaw = AdcioPlacement.adcioSuggest(
                placementId = "9f9f9b00-dc16-41c7-a5cd-f9a788d3d481",
                baseUrl = "https://api-dev.adcio.ai",
            )

            setSuggestionData(suggestionRaw)
        }
    }

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

        adapter = AnalyticsProductionListAdapter(
            onClickPurchase = { logOption ->
                OnPurchaseThread(logOption = logOption).start()
            },
            onClickItem = { logOption ->
                OnClickThread(logOption = logOption).start()
            }
        )

        binding.rvSuggestions.adapter = adapter
        adapter.submitList(productions)

        val getSuggestionThread = GetSuggestionThread()
        getSuggestionThread.start()
    }

    private fun setSuggestionData(suggestionRaw: AdcioSuggestionRaw) {
        productions.clear()
        suggestionRaw.suggestions.forEach {
            productions.add(
                Production(
                    productId = it.product.id,
                    name = it.product.name,
                    image = it.product.image,
                    price = it.product.price.toString(),
                    logOption = AdcioLogOption(requestId = it.logOptions.requestId, adsetId = it.logOptions.adsetId)
                )
            )
        }

        handler.sendEmptyMessage(0)
    }

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (productions.isNotEmpty()) {
                adapter.submitList(productions)
                adapter.notifyDataSetChanged()
            }
        }
    }
}
