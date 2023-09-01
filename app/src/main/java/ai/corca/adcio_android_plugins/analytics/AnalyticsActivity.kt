package ai.corca.adcio_android_plugins.analytics

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.databinding.ActivityAnalyticsBinding
import ai.corca.adcio_android_plugins.placement.Suggestion
import ai.corca.adcio_placement.feature.AdcioPlacement
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnalyticsBinding
    private lateinit var adapter: AnalyticsSuggestionListAdapter
    private var suggestions: MutableList<Suggestion> = emptyList<Suggestion>().toMutableList()

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (suggestions.isNotEmpty()) {
                adapter.submitList(suggestions)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnalyticsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.adcioDetectorAnalytics.option = AdcioLogOption(requestId = "", adsetId = "")

        adapter = AnalyticsSuggestionListAdapter { logOption ->
            OnPurchaseThread(logOption = logOption).start()
        }
        binding.rvSuggestions.adapter = adapter
        adapter.submitList(suggestions)

        val getSuggestionThread = GetSuggestionThread()
        getSuggestionThread.start()
    }

    inner class GetSuggestionThread : Thread() {
        override fun run() {
            val result = AdcioPlacement.adcioSuggest(
                placementId = "9f9f9b00-dc16-41c7-a5cd-f9a788d3d481",
                baseUrl = "https://api-dev.adcio.ai",
            )

            suggestions.clear()
            result.suggestions.forEach {
                suggestions.add(
                    Suggestion(
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
    }

    inner class OnPurchaseThread(
        val logOption: AdcioLogOption
    ) : Thread() {
        override fun run() {
            AdcioAnalytics.onPurchase(
                option = logOption,
                amount = 2,
            )
        }
    }
}
