package ai.corca.adcio_agent

import android.content.Context
import android.content.Intent


//required this.onClickProduct,
//this.baseUrl = 'https://agent.adcio.ai',
//this.onNavigationRequest,
//this.onPageStarted,
//this.onPageFinished,
//this.onProgress,
//this.onWebResourceError,
//this.onUrlChange,

var productId = ""

open class WebViewManager(
    val context: Context?,
    val clientId: String,
    val baseUrl: String = "https://agent-dev.adcio.ai",
) {

    private lateinit var delayedString: String

    fun callAdcioAgent() {
        val startPage = "start/"
        val agentUrl = "${baseUrl}/${clientId}/${startPage}?platform=android"
        val intent = Intent(context, AdcioAgentActivity::class.java)
        intent.putExtra("agentUrl", agentUrl)
        context!!.startActivity(intent)
    }
    fun setDelayedString(value: String) {
        delayedString = value
    }

    fun getDelayedString(): String {
        if (!::delayedString.isInitialized) {
            throw IllegalStateException("Delayed string is not initialized yet.")
        }
        return delayedString
    }

    fun getProductId(id: String) {
        productId = id
    }
}
