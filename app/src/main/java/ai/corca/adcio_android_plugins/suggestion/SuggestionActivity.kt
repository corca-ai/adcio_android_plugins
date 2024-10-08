package ai.corca.adcio_android_plugins.suggestion

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_android_plugins.suggestion.utils.MockProductListAdapter
import ai.corca.adcio_android_plugins.databinding.ActivityPlacementBinding
import ai.corca.adcio_android_plugins.suggestion.helper.GetSuggestionThread
import ai.corca.adcio_android_plugins.suggestion.helper.OnAddToCartThread
import ai.corca.adcio_android_plugins.suggestion.helper.OnClickThread
import ai.corca.adcio_android_plugins.suggestion.helper.OnImpressionThread
import ai.corca.adcio_android_plugins.suggestion.helper.OnPurchaseThread
import ai.corca.adcio_android_plugins.suggestion.helper.productions
import ai.corca.adcio_android_plugins.suggestion.user.Gender
import ai.corca.adcio_android_plugins.suggestion.user.User
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.amplitude.api.Amplitude
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Calendar
import java.util.UUID

lateinit var currentUser: User
lateinit var currentLocation: String

lateinit var mockProductListAdapter: MockProductListAdapter

lateinit var adcioAnalytics: AdcioAnalytics

class SuggestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacementBinding

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appVersion = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            this.packageManager.getPackageInfo(this.packageName, PackageManager.PackageInfoFlags.of(0))
        } else {
            @Suppress("DEPRECATION")
            this.packageManager.getPackageInfo(this.packageName, 0)
        }.versionName


        val getSuggestionThread = GetSuggestionThread(this, appVersion = appVersion)
        adcioAnalytics = AdcioAnalytics("7bbb703e-a30b-4a4a-91b4-c0a7d2303415", appVersion = appVersion, this)


        mockProductListAdapter = MockProductListAdapter(
            onImpressionItem = { logOption ->
                OnImpressionThread(
                    logOption = logOption
                ).start()
            },

            onPurchaseItem = {
                OnPurchaseThread(
                    orderId = "SAMPLE_ORDER_ID",
                    productIdOnStore = "SAMPLE_PRODUCT_ID",
                    amount = 0
                ).start()
            },

            onClickItem = { logOption ->
                OnClickThread(
                    logOption = logOption
                ).start()
            },

            onAddToCart = { productId ->
                OnAddToCartThread(
                    productIdOnStore = productId
                ).start()
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
