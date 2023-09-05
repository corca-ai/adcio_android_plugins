package ai.corca.adcio_agent_compose.agent

import ai.corca.adcio_agent_compose.provider.AdcioAgentCompose
import android.annotation.SuppressLint
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@SuppressLint("StaticFieldLeak")
private lateinit var webViewState: WebView

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun callAdcioAgent(
    modifier: Modifier = Modifier.fillMaxSize(),
    clientId: String,
    /**
     *  A URL configuration parameter for library developers.
     *  It has nothing to do with the clients, so please don't reveal it.
     */
    baseUrl: String = "https://agent.adcio.ai",
    showAppBar: Boolean = false,
) {
    val startPage = "start/"
    val agentUrl = "$baseUrl/$clientId/$startPage?platform=android&show_appbar=$showAppBar"

    WebView(
        modifier = modifier,
        state = rememberWebViewState(url = agentUrl),
        onCreated={ webView ->
            with(webView){
                // Webview permission settings
                settings.run{
                    javaScriptEnabled = true
                    domStorageEnabled = true
                    javaScriptCanOpenWindowsAutomatically = false
                }
                addJavascriptInterface(ProductRouterJavascriptInterface(), "ProductRouter")
            }
            webViewState = webView
        },
    )
}

/**
 * Implementation of Agent management functions
 */
internal class WebViewStateManager {
    val isAgentStartPage: Boolean
        get() = if (::webViewState.isInitialized) webViewState.url?.contains("start/") ?: true else false

    fun agentBackManager(): Boolean {
        return if (::webViewState.isInitialized && webViewState.canGoBack()) {
            webViewState.goBack()
            false
        } else {
            true
        }
    }
}

internal class ProductRouterJavascriptInterface {

    private val adcioAgentCompose = AdcioAgentCompose()

    @JavascriptInterface
    fun postMessage(message: String){
        adcioAgentCompose.setProductId(message)
    }
}
