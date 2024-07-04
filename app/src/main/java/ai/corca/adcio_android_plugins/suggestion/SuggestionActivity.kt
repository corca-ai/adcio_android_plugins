package ai.corca.adcio_android_plugins.suggestion

import ai.corca.adcio_analytics.AdcioAnalytics
import ai.corca.adcio_android_plugins.suggestion.utils.MockProductListAdapter
import ai.corca.adcio_android_plugins.databinding.ActivityPlacementBinding
import ai.corca.adcio_android_plugins.suggestion.helper.handleResultData
import ai.corca.adcio_android_plugins.suggestion.helper.productions
import ai.corca.adcio_android_plugins.suggestion.model.Production
import ai.corca.adcio_android_plugins.suggestion.user.Gender
import ai.corca.adcio_android_plugins.suggestion.user.User
import ai.corca.adcio_android_plugins.suggestion.utils.clearImpressionHistory
import ai.corca.adcio_placement.AdcioPlacement
import ai.corca.placement.model.ProductFilterOperationDto
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

lateinit var currentUser: User
lateinit var currentLocation: String

lateinit var mockProductListAdapter: MockProductListAdapter

private val _productState = MutableStateFlow(emptyList<Production>())
val productions: StateFlow<List<Production>> = _productState

class SuggestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacementBinding

    val analytics = AdcioAnalytics("76dc12fa-5a73-4c90-bea5-d6578f9bc606")

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

        val sampleBirthDate = Calendar.getInstance()
        sampleBirthDate.set(Calendar.YEAR, 2000)
        sampleBirthDate.set(Calendar.MONTH, Calendar.JANUARY)
        sampleBirthDate.set(Calendar.DAY_OF_MONTH, 31)

        currentUser = User(
            id = UUID.randomUUID().toString(),
            name = "adcio",
            birthDate = LocalDate.of(2000, 1, 31),
            gender = Gender.female,
        )

        currentLocation = "Seoul, Korea"

        val adcioSuggestionRaw = runBlocking {
            AdcioPlacement.createAdvertisementProducts(
                clientId = "76dc12fa-5a73-4c90-bea5-d6578f9bc606",
                placementId = "5ae9907f-3cc2-4ed4-aaa4-4b20ac97f9f4",
                categoryId = "2179",
                excludingProductIds = listOf("1001"),
                customerId = currentUser.id,
                filters = mapOf(
                    "price_excluding_tax" to ProductFilterOperationDto(not = 53636),
                    "product_code" to ProductFilterOperationDto(contains = "KY"),
                    "province_id" to ProductFilterOperationDto(equalTo = 1)
                ),
            )
        }

        clearImpressionHistory()

        if (adcioSuggestionRaw != null) {
            handleResultData(adcioSuggestionRaw)
        }

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
