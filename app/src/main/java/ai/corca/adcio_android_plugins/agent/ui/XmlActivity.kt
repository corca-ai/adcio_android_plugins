package ai.corca.adcio_android_plugins.agent.ui

import ai.corca.adcio_agent.provider.WebViewManager
import ai.corca.adcio_android_plugins.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class XmlActivity : AppCompatActivity() {

    private val webViewManager = WebViewManager(
        context = this,
        clientId = "30cb6fd0-17a5-4c56-b144-fef67de81bef",
        baseUrl = "https://agent-dev.adcio.ai",
        fragmentContainer = R.id.adcio_webview_frame
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml)
        webViewManager.callAdcioAgent()
    }
}
