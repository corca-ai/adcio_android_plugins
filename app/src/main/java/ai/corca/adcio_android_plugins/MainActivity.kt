package ai.corca.adcio_android_plugins

import ai.corca.adcio_android_plugins.agent.AgentActivity
import ai.corca.adcio_android_plugins.analytics.AnalyticsActivity
import ai.corca.adcio_android_plugins.core.CoreActivity
import ai.corca.adcio_android_plugins.databinding.ActivityMainBinding
import ai.corca.adcio_android_plugins.placement.PlacementActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.corcaai.adcio_core.feature.AdcioCore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // You should init to use getClientId
        // Also you must init any parts that use ClientId in the placement or analytics module.
        AdcioCore.initializeApp("67592c00-a230-4c31-902e-82ae4fe71866")

        binding.btnAgent.setOnClickListener {
            val intent = Intent(this, AgentActivity::class.java)
            startActivity(intent)
        }

        binding.btnAnalytics.setOnClickListener {
            val intent = Intent(this, AnalyticsActivity::class.java)
            startActivity(intent)
        }

        binding.btnPlacement.setOnClickListener {
            val intent = Intent(this, PlacementActivity::class.java)
            startActivity(intent)
        }

        binding.btnCore.setOnClickListener {
            val intent = Intent(this, CoreActivity::class.java)
            startActivity(intent)
        }
    }
}
