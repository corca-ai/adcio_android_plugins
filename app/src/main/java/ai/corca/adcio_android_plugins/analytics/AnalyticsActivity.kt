package ai.corca.adcio_android_plugins.analytics

import ai.corca.adcio_android_plugins.databinding.ActivityAnalyticsBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnalyticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnalyticsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}