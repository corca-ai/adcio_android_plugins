package ai.corca.adcio_android_plugins

import ai.corca.adcio_android_plugins.agent.AgentActivity
import ai.corca.adcio_android_plugins.analytics.AnalyticsActivity
import ai.corca.adcio_android_plugins.core.CoreActivity
import ai.corca.adcio_android_plugins.databinding.ActivityMainBinding
import ai.corca.adcio_android_plugins.placement.PlacementActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
