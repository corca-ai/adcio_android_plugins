package ai.corca.adcio_android_plugins.suggestion

import ai.corca.adcio_analytics.AdcioAnalytics
import ai.corca.adcio_android_plugins.suggestion.utils.MockProductListAdapter
import ai.corca.adcio_android_plugins.databinding.ActivityPlacementBinding
import ai.corca.adcio_android_plugins.suggestion.helper.GetSuggestionThread
import ai.corca.adcio_android_plugins.suggestion.helper.handleResultData
import ai.corca.adcio_android_plugins.suggestion.helper.productions
import ai.corca.adcio_android_plugins.suggestion.model.Production
import ai.corca.adcio_android_plugins.suggestion.user.Gender
import ai.corca.adcio_android_plugins.suggestion.user.User
import ai.corca.adcio_android_plugins.suggestion.utils.clearImpressionHistory
import ai.corca.adcio_placement.AdcioPlacement
import ai.corca.generator_placement.model.ProductFilterOperationDto
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDate
import java.util.Calendar
import java.util.UUID

lateinit var mockProductListAdapter: MockProductListAdapter

class SuggestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacementBinding

     val analytics = AdcioAnalytics("7bbb703e-a30b-4a4a-91b4-c0a7d2303415")

    private val getSuggestionThread = GetSuggestionThread()

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mockProductListAdapter = MockProductListAdapter(
            onImpressionItem = { logOption ->
                analytics.onImpression(
                    option = logOption,
                    customerId = null,
                    productIdOnStore = null
                )
            },

            onPurchaseItem = {
                analytics.onPurchase(
                    orderId = "SAMPLE_ORDER_ID",
                    productIdOnStore = "SAMPLE_PRODUCT_ID",
                    amount = 0
                )
            },

            onClickItem = { logOption ->
                analytics.onClick(
                    option = logOption
                )
            },

            onAddToCart = { productId ->
                analytics.onAddToCart(
                    productIdOnStore = productId
                )
            },
        )

        getSuggestionThread.start()
        getSuggestionData()

        binding.rvSuggestions.adapter = mockProductListAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getSuggestionData() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            productions.collect { products ->
                if (products.isNotEmpty()) {
                    val myProducts = products.shuffled()
                    mockProductListAdapter.submitList(myProducts)
                    mockProductListAdapter.notifyDataSetChanged()
                    mockProductListAdapter.attachToRecyclerView(binding.rvSuggestions)
                }
            }
        }
    }
}
