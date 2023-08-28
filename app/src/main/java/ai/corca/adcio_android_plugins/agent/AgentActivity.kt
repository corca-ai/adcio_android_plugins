package ai.corca.adcio_android_plugins.agent

import ai.corca.adcio_agent.provider.WebViewManager
import ai.corca.adcio_agent.provider.productId
import ai.corca.adcio_android_plugins.R
import ai.corca.adcio_android_plugins.agent.ui.ComposeActivity
import ai.corca.adcio_android_plugins.agent.ui.XmlActivity
import ai.corca.adcio_android_plugins.databinding.ActivityAgentBinding
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AgentActivity : AppCompatActivity() {

    lateinit var binding: ActivityAgentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnXml.setOnClickListener {
            val intent = Intent(this, XmlActivity::class.java)
            startActivity(intent)
        }

        binding.btnCompose.setOnClickListener {
            val intent = Intent(this, ComposeActivity::class.java)
            startActivity(intent)
        }
    }

    private val webViewManager = WebViewManager(
        context = this,
        clientId = "30cb6fd0-17a5-4c56-b144-fef67de81bef",
        "https://agent-dev.adcio.ai",
        R.id.adcio_webview_frame
    )

    override fun onRestart() {
        super.onRestart()
        webViewManager.setDelayedString(productId)
        val getProductId = webViewManager.getDelayedString()
        if (getProductId != "") {
            Toast.makeText(this, productId, Toast.LENGTH_SHORT).show()
        }
    }
}

