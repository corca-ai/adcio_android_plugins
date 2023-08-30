package ai.corca.adcio_android_plugins.agent.ui

import ai.corca.adcio_agent.provider.ProductChangeListener
import ai.corca.adcio_agent.provider.WebViewManager
import ai.corca.adcio_agent.provider.productChangeListener
import ai.corca.adcio_android_plugins.R
import ai.corca.adcio_android_plugins.databinding.ActivityXmlBinding
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class XmlActivity : AppCompatActivity() {

    lateinit var binding: ActivityXmlBinding

    private val webViewManager = WebViewManager(
        context = this,
        clientId = "30cb6fd0-17a5-4c56-b144-fef67de81bef",
        baseUrl = "https://agent-dev.adcio.ai",
        fragmentContainer = R.id.adcio_webview_frame,
        showAppBar = false
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        webViewManager.callAdcioAgent()

        productChangeListener = object : ProductChangeListener {
            override fun onProductIdChanged(newId: String) {
                Toast.makeText(this@XmlActivity, newId, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
