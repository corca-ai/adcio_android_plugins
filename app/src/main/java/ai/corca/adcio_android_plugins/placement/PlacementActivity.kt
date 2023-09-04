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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PlacementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacementBinding
    private lateinit var suggestionListAdapter: SuggestionListAdapter
    private var productions: MutableList<Production> = emptyList<Production>().toMutableList()

    inner class GetSuggestionThread : Thread() {
        override fun run() {
            // You can obtain recommended data through the AdcioPlacement.adcioSuggest() function.
            // You can put only one placementId.
            // However, if you hand over additional data such as customerId, placementPosX,
            // placementPosY, age, gender, and area, you can get a better recommendation.
            val adcioSuggestionRaw = AdcioPlacement.adcioSuggest(
                placementId = "9f9f9b00-dc16-41c7-a5cd-f9a788d3d481",
            )
            // You can receive an AdcioSuggestonRaw object as a result,
            // which contains recommended items.
            // Take advantage of this object!

            handleResultData(adcioSuggestionRaw)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDeviceId.setOnClickListener {
            // You can get your registered device ID!
            // ex) TP1A.220612.012
            val deviceId = AdcioPlacement.getDeviceId()
            // You can also change the registered DeviceID value through the info parameter.

            Toast.makeText(this, "Device Id: $deviceId", Toast.LENGTH_SHORT).show()
        }

        binding.tvSessionId.setOnClickListener {
            // You can get your registered session ID!
            // ex) 70828121-1234-47d71-fh71-fy71j47s83jd
            val sessionId = AdcioPlacement.getSessionId()
            // You can also change the registered SessionID value through the info parameter.

            Toast.makeText(this, "Session Id: $sessionId", Toast.LENGTH_SHORT).show()
        }

        // From the bottom, this is the basic view setting.
        setOtherViews()
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

    private fun handleResultData(adcioSuggestionRaw: AdcioSuggestionRaw) {
        productions.clear()
        adcioSuggestionRaw.suggestions.forEach {
            productions.add(
                Production(
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

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (productions.isNotEmpty()) {
                suggestionListAdapter.submitList(productions)
                suggestionListAdapter.notifyDataSetChanged()
            }
        }
    }
}
