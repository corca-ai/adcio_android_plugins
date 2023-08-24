package ai.corca.adcio_android_plugins.analytics

import ai.corca.adcio_android_plugins.databinding.ActivityAnalyticsBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnalyticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnalyticsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
