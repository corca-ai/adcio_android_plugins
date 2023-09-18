package ai.corca.adcio_agent_compose.agent

import ai.corca.adcio_agent_compose.provider.AdcioAgentCompose
import android.annotation.SuppressLint
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.corcaai.adcio_core.feature.AdcioCore
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@SuppressLint("StaticFieldLeak")
private lateinit var webViewState: WebView

/**
 * composable function for agent.
 *
 * @param modifier to resize.
 * @param clientId your client id.
 * @param showAppBar you can change visibility of appbar in web.
 */
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AdcioAgent(
    modifier: Modifier = Modifier.fillMaxSize(),

    // Your Adcio ClientId, If you do not enter it, the ID value entered during init will be entered.
    clientId: String? = null,

    // A URL configuration parameter for library developers.
    // It has nothing to do with the clients, so please don't reveal it.
    showAppBar: Boolean = false,
    baseUrl: String = "https://agent.adcio.ai",
) {
    val startPage = "start/"
    val agentUrl = "$baseUrl/${clientId ?: AdcioCore.clientId}/$startPage?platform=android&show_appbar=$showAppBar"

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
