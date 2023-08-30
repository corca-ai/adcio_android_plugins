package ai.corca.adcio_agent.provider

import ai.corca.adcio_agent.agent.AdcioAgent
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates

interface ProductChangeListener {
    fun onProductIdChanged(newId: String)
}

var productChangeListener: ProductChangeListener? = null

private var _productId: String by Delegates.observable("") { _, _, new ->
    productChangeListener?.onProductIdChanged(new)
}

open class WebViewManager(
    val context: Context?,
    val clientId: String,
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

        val fragment = AdcioAgent.newInstance(agentUrl)
        fragmentTransaction.replace(fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun isAgentStartPage(): Boolean = AdcioAgent().isAgentStartPage

    fun agentGoBack(): Boolean = AdcioAgent().agentBackManager()

    internal fun setProductId(newProductId: String) {
        _productId = newProductId
    }
}
