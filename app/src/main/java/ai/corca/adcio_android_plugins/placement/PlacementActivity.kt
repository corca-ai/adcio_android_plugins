package ai.corca.adcio_android_plugins.placement

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.databinding.ActivityPlacementBinding
import ai.corca.adcio_placement.feature.AdcioPlacement
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PlacementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacementBinding
    private lateinit var suggestionListAdapter: SuggestionListAdapter
    private var suggestions: MutableList<Suggestion> = emptyList<Suggestion>().toMutableList()

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (suggestions.isNotEmpty()) {
                suggestionListAdapter.submitList(suggestions)
                suggestionListAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        suggestionListAdapter = SuggestionListAdapter()
        binding.rvSuggestions.adapter = suggestionListAdapter
        suggestionListAdapter.submitList(suggestions)

        binding.ivRefresh.setOnClickListener {
            GetFakeSuggestionThread().start()
        }

        binding.tvDeviceId.setOnClickListener {
            Toast.makeText(this, "Device Id: ${AdcioPlacement.getDeviceId()}", Toast.LENGTH_SHORT).show()
        }

        binding.tvSessionId.setOnClickListener {
            Toast.makeText(this, "Session Id: ${AdcioPlacement.getSessionId()}", Toast.LENGTH_SHORT).show()
        }

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
                        logOption = AdcioLogOption(requestId = it.logOptions.requestId, adsetId = it.logOptions.adsetId),
                    )
                )
            }

            handler.sendEmptyMessage(0)
        }
    }

    inner class GetFakeSuggestionThread : Thread() {
        override fun run() {
            try {
                val result = AdcioPlacement.adcioSuggest(
                    placementId = "9f9f9b00-dc16-41c7-a5cd-f9a788d3d481",
                    baseUrl = "https://api-dev.adcio.aiii",
                )

                suggestions.clear()
                result.suggestions.forEach {
                    suggestions.add(
                        Suggestion(
                            productId = it.product.id,
                            name = it.product.name,
                            image = it.product.image,
                            price = it.product.price.toString(),
                            logOption = AdcioLogOption(requestId = it.logOptions.requestId, adsetId = it.logOptions.adsetId),
                        )
                    )
                }
            } catch (e: Exception) {
                Log.e("TestLogLog", e.stackTraceToString())
            }

            handler.sendEmptyMessage(0)
        }
    }
}
