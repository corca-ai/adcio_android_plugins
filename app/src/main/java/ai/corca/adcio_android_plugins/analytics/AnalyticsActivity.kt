package ai.corca.adcio_android_plugins.analytics

import ai.corca.adcio_analytics.feature.AdcioImpressionDetectorManager
import ai.corca.adcio_android_plugins.AdcioAndroidPluginsApplication
import ai.corca.adcio_android_plugins.databinding.ActivityAnalyticsBinding
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnalyticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnalyticsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = applicationContext as AdcioAndroidPluginsApplication
        app.adcioAnalyticsHistory.addImpressionHistory("asdf")

        binding.adcioImpression.manager = AdcioImpressionDetectorManager(
            adcioAnalyticsHistory = app.adcioAnalyticsHistory,
            requestId = "",
            adsetId = "",
        )

        Log.d("TESTTEST", "${app.adcioAnalyticsHistory.getImpressionHistories()}")
    }
}
