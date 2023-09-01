package ai.corca.adcio_agent.provider

import ai.corca.adcio_agent.agent.AgentClient
import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates

interface AdcioAgentListener {
    fun onClickProductId(productId: String)
}

var adcioAgentListener: AdcioAgentListener? = null

private var _productId: String by Delegates.observable("") { _, _, new ->
    adcioAgentListener?.onClickProductId(new)
}

open class AdcioAgent(
    val context: Context?,
    val clientId: String,
    /**
     *  A URL configuration parameter for library developers.
     *  It has nothing to do with the clients, so please don't reveal it.
     */
    val baseUrl: String = "https://agent-dev.adcio.ai",

    /**
     * Your FrameLayout Resource ID But, We Recommand our AdcioAgentLayout
     */
    val fragmentContainer: Int,
    private val showAppBar: Boolean = false,
) {
    /**
     * Call ADCIO Agent Webview in FrameLayout by your fragmentId Param
     *
     * 💡 If it happen product click event the Agent will be destroy
     */
    fun callAdcioAgent() {
        val startPage = "start/"
        val agentUrl = "$baseUrl/$clientId/$startPage?platform=android&show_appbar=$showAppBar"
        val fragmentManager = (context as AppCompatActivity).supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = AgentClient.newInstance(agentUrl)
        fragmentTransaction.replace(fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun isAgentStartPage(): Boolean = AgentClient().pageManager.isAgentStartPage()

    fun agentGoBack(): Boolean = AgentClient().pageManager.agentGoBack()

    internal fun setProductId(newProductId: String) {
        _productId = newProductId
    }
}
