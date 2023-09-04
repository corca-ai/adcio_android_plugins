package ai.corca.adcio_android_plugins.usecases.mockapp

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_android_plugins.AdcioAndroidPluginsApplication
import ai.corca.adcio_android_plugins.R
import ai.corca.adcio_android_plugins.databinding.ActivityMockBinding
import ai.corca.adcio_placement.feature.AdcioPlacement
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController

class MockActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMockBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = applicationContext as AdcioAndroidPluginsApplication
        AdcioPlacement.initPlacement(app.adcioAnalyticsHistory)
        AdcioAnalytics.initAnalytics(app.adcioAnalyticsHistory)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_mock) as NavHostFragment
        val navController = navHostFragment.findNavController()
        binding.bnvMock.setupWithNavController(navController)
    }
}