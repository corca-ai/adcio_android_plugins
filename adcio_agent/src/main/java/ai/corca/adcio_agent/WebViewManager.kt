package ai.corca.adcio_agent

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

var productId = ""

open class WebViewManager(
    val context: Context?,
    val clientId: String,
    val baseUrl: String = "https://agent-dev.adcio.ai",
    val fragmentContainer: Int
) {

    private lateinit var delayedString: String

    fun callAdcioAgent() {
        val startPage = "start/"
        val agentUrl = "$baseUrl/$clientId/$startPage?platform=android"
        val fragmentManager = (context as AppCompatActivity).supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = AdcioAgent.newInstance(agentUrl)
        fragmentTransaction.replace(fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
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
