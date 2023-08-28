package ai.corca.adcio_android_plugins

import ai.corca.adcio_agent.WebViewManager
import ai.corca.adcio_agent.productId
import ai.corca.adcio_android_plugins.agent.AgentActivity
import ai.corca.adcio_android_plugins.analytics.AnalyticsActivity
import ai.corca.adcio_android_plugins.databinding.ActivityMainBinding
import ai.corca.adcio_android_plugins.placement.PlacementActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
    }

    private val webViewManager = WebViewManager(
        context = this,
        clientId = "30cb6fd0-17a5-4c56-b144-fef67de81bef",
        "https://agent-dev.adcio.ai",
        R.id.frame
    )

    override fun onRestart() {
        super.onRestart()
        webViewManager.setDelayedString(productId)
        val getProductId = webViewManager.getDelayedString()
        if (getProductId != "") {
            Toast.makeText(this, webViewManager.getDelayedString(), Toast.LENGTH_SHORT).show()
        }
    }
}
