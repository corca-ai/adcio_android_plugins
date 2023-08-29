package ai.corca.adcio_agent_compose.agent

import ai.corca.adcio_agent_compose.provider.ComposeWebViewManager
import android.app.Activity
import android.content.Context
import android.webkit.JavascriptInterface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.AccompanistWebChromeClient
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun callAdcioAgent(
    clientId: String,
    baseUrl: String = "https://agent-dev.adcio.ai",
    activity: Activity,
) {
    val startPage = "start/"
    val agentUrl = "$baseUrl/$clientId/$startPage?platform=android"

    val webViewState =
        rememberWebViewState(
            url = agentUrl,
            additionalHttpHeaders = emptyMap()
        )
    val webViewClient = AccompanistWebViewClient()
    val webChromeClient = AccompanistWebChromeClient()

    WebView(
        state = webViewState,
        client = webViewClient,
        chromeClient = webChromeClient,
        onCreated = { webView ->
            with(webView) {
                settings.run {
                    javaScriptEnabled = true
                    domStorageEnabled = true
                    javaScriptCanOpenWindowsAutomatically = false
                }
                addJavascriptInterface(ProductRouterJavascriptInterface(activity), "ProductRouter")
            }
        }
    )
}

class ProductRouterJavascriptInterface(private val activity: Activity) {
    @JavascriptInterface
    fun postMessage(message: String) {
        webViewManager.getProductId(message)
        activity.finish()
    }
}

val webViewManager = ComposeWebViewManager()
