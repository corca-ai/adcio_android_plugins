package ai.corca.adcio_android_plugins.placement

import ai.corca.adcio_android_plugins.databinding.ActivityPlacementBinding
import ai.corca.adcio_placement.feature.AdcioPlacement
import ai.corca.adcio_placement.model.AdcioSuggestion
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PlacementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacementBinding
    private lateinit var suggestionListAdapter: SuggestionListAdapter
    private val suggestions: List<Suggestion> = emptyList()

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

        val getSuggestionThread = GetSuggestionThread()
        getSuggestionThread.start()
    }

    inner class GetSuggestionThread: Thread() {
        override fun run() {
            val result = AdcioPlacement().adcioSuggest(
                placementId = "9f9f9b00-dc16-41c7-a5cd-f9a788d3d481",
                baseUrl = "https://api-dev.adcio.ai",
            )
            result.suggestions.forEach {
                suggestions.toMutableList().add(
                    Suggestion(
                        name = it.product.name,
                        image = it.product.image,
                    )
                )
            }

            suggestionListAdapter.submitList(suggestions)
        }
    }
}
