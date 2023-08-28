package ai.corca.adcio_android_plugins.agent.ui

import ai.corca.adcio_agent.provider.WebViewManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ai.corca.adcio_android_plugins.R

class XmlActivity : AppCompatActivity() {

    private val webViewManager = WebViewManager(
        context = this,
        clientId = "30cb6fd0-17a5-4c56-b144-fef67de81bef",
        "https://agent-dev.adcio.ai",
        R.id.adcio_webview_frame
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml)
        webViewManager.callAdcioAgent()
    }
}