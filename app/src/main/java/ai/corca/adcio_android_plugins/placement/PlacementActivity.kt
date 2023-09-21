package ai.corca.adcio_android_plugins.placement

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.databinding.ActivityPlacementBinding
import ai.corca.adcio_android_plugins.placement.utils.Production
import ai.corca.adcio_android_plugins.placement.utils.SuggestionListAdapter
import ai.corca.adcio_placement.feature.AdcioPlacement
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity

class PlacementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacementBinding
    private lateinit var suggestionListAdapter: SuggestionListAdapter
    private var productions: MutableList<Production> = emptyList<Production>().toMutableList()

    inner class GetSuggestionThread : Thread() {
        override fun run() {
            // adcioSuggest function allows you to receive products recommended by ADCIO’s AI.
            // You can get the placementId on the ADCIO Dashboard web page.
            // In addition, if you have user information such as customerId(like.userId),
            // age, gender, area, or information such as placement position related to the page,
            // the recommended prediction accuracy is higher.
            val adcioSuggestionRaw = AdcioPlacement.adcioSuggest(
                placementId = "67592c00-a230-4c31-902e-82ae4fe71866",
            )
            // You can receive an AdcioSuggestonRaw object as a result,

            handleResultData(adcioSuggestionRaw)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacementBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // From the bottom, this is the basic view setting.

        setOtherViews()
    }

    private fun handleResultData(adcioSuggestionRaw: AdcioSuggestionRaw) {
        productions.clear()
        adcioSuggestionRaw.suggestions.forEach {
            productions.add(
                Production(
                    productId = it.product.code, // product.code = product id of client service
                    name = it.product.name,
                    image = it.product.image,
                    price = it.product.price.toString(),
                    logOption = AdcioLogOption(requestId = it.logOptions.requestId, adsetId = it.logOptions.adsetId),
                )
            )
        }
        handler.sendEmptyMessage(0)
    }

    private fun setOtherViews() {
        suggestionListAdapter = SuggestionListAdapter()
        binding.rvSuggestions.adapter = suggestionListAdapter
        suggestionListAdapter.submitList(productions)

        binding.ivRefresh.setOnClickListener {
            GetSuggestionThread().start()
        }

        val getSuggestionThread = GetSuggestionThread()
        getSuggestionThread.start()
    }

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (productions.isNotEmpty()) {
                suggestionListAdapter.submitList(productions)
                suggestionListAdapter.notifyDataSetChanged()
            }
        }
    }
}
