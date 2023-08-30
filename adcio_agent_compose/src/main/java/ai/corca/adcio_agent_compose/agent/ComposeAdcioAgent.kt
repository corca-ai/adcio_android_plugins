package ai.corca.adcio_agent_compose.agent

import ai.corca.adcio_agent_compose.provider.ComposeWebViewManager
import android.annotation.SuppressLint
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@SuppressLint("StaticFieldLeak")
private lateinit var webViewState: WebView

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun callAdcioAgent(
    modifier: Modifier = Modifier,
    clientId: String,
    baseUrl: String = "https://agent-dev.adcio.ai",
    showAppBar: Boolean = false,
) {
    val startPage = "start/"
    val agentUrl = "$baseUrl/$clientId/$startPage?platform=android&show_appbar=$showAppBar"

    WebView(
        modifier = modifier,
        state = rememberWebViewState(url=agentUrl),
        onCreated={ webView ->
            with(webView){
                settings.run{
                    javaScriptEnabled=true
                    domStorageEnabled=true
                    javaScriptCanOpenWindowsAutomatically=false
                }
                addJavascriptInterface(ProductRouterJavascriptInterface(), "ProductRouter")
            }
            webViewState = webView
        },
    )
}

class WebViewStateManager {
    val isAgentStartPage: Boolean
        get() = webViewState.url?.contains("start/") ?: false

    fun agentBackManager(): Boolean {
        return if (webViewState.canGoBack()) {
            webViewState.goBack()
            false
        } else {
            true
        }
    }
}

class ProductRouterJavascriptInterface() {

    private val composeWebViewManager = ComposeWebViewManager()

    @JavascriptInterface
    fun postMessage(message: String){
        composeWebViewManager.setProductId(message)
    }
}
