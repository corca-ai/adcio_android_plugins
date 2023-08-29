package ai.corca.adcio_agent_compose.agent

import ai.corca.adcio_agent_compose.provider.ComposeWebViewManager
import android.annotation.SuppressLint
import android.webkit.JavascriptInterface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

class ViewManager {
    var getProductId: String = ""
    var postMessageCalled = mutableStateOf(false)
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun callAdcioAgent(
    modifier: Modifier = Modifier,
    clientId: String,
    baseUrl: String = "https://agent-dev.adcio.ai",
    navController: NavController
) {
    val startPage = "start/"
    val agentUrl = "$baseUrl/$clientId/$startPage?platform=android"

    val webViewManager = remember { ViewManager() }

    if (webViewManager.postMessageCalled.value) {
        navController.popBackStack("main", false)
        webViewManager.postMessageCalled.value = false
    }

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
                addJavascriptInterface(ProductRouterJavascriptInterface(webViewManager), "ProductRouter")
            }
        },
    )
}

class ProductRouterJavascriptInterface(private val viewManager: ViewManager) {

    private val composeWebViewManager = ComposeWebViewManager()

    @JavascriptInterface
    fun postMessage(message: String){
        composeWebViewManager.getProductId(message)
        viewManager.postMessageCalled.value=true
    }
}
