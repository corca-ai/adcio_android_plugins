package ai.corca.adcio_agent_compose.provider

import ai.corca.adcio_agent_compose.agent.WebViewStateManager
import android.util.Log
import androidx.compose.runtime.mutableStateOf

/**
 * When a product is clicked on Agent, the clicked productId is updated in productId.
 */
val productId = mutableStateOf("")

class AdcioAgentCompose {

    /**
     * Returns whether the current page is the first page of the agent's page.
     */
    fun isAgentStartPage(): Boolean = WebViewStateManager().isAgentStartPage

    /**
     * An action to navigate back to the previous page in the agent's page.
     */
    fun agentGoBack(): Boolean = WebViewStateManager().agentBackManager()

    internal fun setProductId(newProductId: String) {
        productId.value = newProductId
    }
}
