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
                settings.run{
                    javaScriptEnabled = true // JavaScript 실행 여부
                    domStorageEnabled = true // WebView DOM Storage 사용 여부 (ADCIO 채팅 기록)
                    javaScriptCanOpenWindowsAutomatically = false // JavaScript의 새 창 열기 여부
                }
                /**
                 * 브릿지 요청 감지
                 */
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
