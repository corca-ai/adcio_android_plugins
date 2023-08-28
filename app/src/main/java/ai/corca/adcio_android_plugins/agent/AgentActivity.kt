package ai.corca.adcio_android_plugins.agent

import ai.corca.adcio_android_plugins.AdcioAndroidPluginsApplication
import ai.corca.adcio_android_plugins.databinding.ActivityAgentBinding
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class AgentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = applicationContext as AdcioAndroidPluginsApplication
        app.adcioAnalyticsHistory.addImpressionHistory("asdfasdf")

        Log.d("TESTTEST", "${app.adcioAnalyticsHistory.getImpressionHistories()}")
    }
}
