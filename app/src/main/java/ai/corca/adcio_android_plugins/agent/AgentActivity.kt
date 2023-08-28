package ai.corca.adcio_android_plugins.agent

import ai.corca.adcio_agent.WebViewManager
import ai.corca.adcio_android_plugins.R
import ai.corca.adcio_android_plugins.databinding.ActivityAgentBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class AgentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgentBinding

    private val webViewManager = WebViewManager(
        context = this,
        clientId = "30cb6fd0-17a5-4c56-b144-fef67de81bef",
        "https://agent-dev.adcio.ai",
        R.id.frame
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_agent)
        webViewManager.callAdcioAgent()
    }
}
