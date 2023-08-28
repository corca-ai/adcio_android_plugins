package ai.corca.adcio_android_plugins.placement

import ai.corca.adcio_android_plugins.databinding.ActivityPlacementBinding
import ai.corca.adcio_placement.feature.AdcioPlacement
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
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
            GetSuggestionThread().start()
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
                        name = it.product.name,
                        image = it.product.image,
                    )
                )
            }

            handler.sendEmptyMessage(0)
        }
    }
}
