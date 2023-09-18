package ai.corca.adcio_agent.provider

import ai.corca.adcio_agent.agent.AgentClient
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.corcaai.adcio_core.feature.AdcioCore
import kotlin.properties.Delegates

interface AdcioAgentListener {
    fun onClickProduct(productId: String)
}

var adcioAgentListener: AdcioAgentListener? = null

private var _productId: String by Delegates.observable("") { _, _, new ->
    adcioAgentListener?.onClickProduct(new)
}

class AdcioAgent(
    val context: Context?,

    // A URL configuration parameter for library developers.
    // It has nothing to do with the clients, so please don't reveal it.
    val baseUrl: String = "https://agent.adcio.ai",

    // Your Adcio ClientId, If you do not enter it, the ID value entered during init will be entered.
    val clientId: String? = null,

    // Your FrameLayout Resource ID But, We Recommand our AdcioAgentLayout
    val fragmentContainer: Int,
    private val showAppBar: Boolean = false,
) {
    /**
     * Call ADCIO Agent Webview in FrameLayout by your fragmentId Param
     *
     * 💡 If it happen product clicked event the Agent will update productId
     */
    fun callAdcioAgent() {
        val startPage = "start/"
        val agentUrl = "$baseUrl/${clientId ?: AdcioCore.clientId}/$startPage?platform=android&show_appbar=$showAppBar"
        val fragmentManager = (context as AppCompatActivity).supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = AgentClient.newInstance(agentUrl)
        fragmentTransaction.replace(fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    /**
     * Returns whether the current page is the first page of the agent's page.
     */
    fun isAgentStartPage(): Boolean {
        return AgentClient().pageManager?.agentGoBack() != true
    }

    /**
     * An action to navigate back to the previous page in the agent's page.
     */
    fun agentGoBack(): Boolean = AgentClient().pageManager?.agentGoBack() == true

    internal fun setProductId(newProductId: String) {
        _productId = newProductId
    }
}
