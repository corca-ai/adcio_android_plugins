package ai.corca.adcio_agent_compose.provider

import ai.corca.adcio_agent_compose.agent.WebViewStateManager
import android.util.Log
import androidx.compose.runtime.mutableStateOf

val productId = mutableStateOf("")

class ComposeWebViewManager {
    /**
     * You Should Initialize by this func before getDelayedString()
     */
    fun isAgentStartPage(): Boolean = WebViewStateManager().isAgentStartPage

    fun agentGoBack(): Boolean = WebViewStateManager().agentBackManager()

    internal fun setProductId(newProductId: String) {
        productId.value = newProductId
        Log.d("taglog", newProductId)

    }
}
