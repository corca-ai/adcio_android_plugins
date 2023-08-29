package ai.corca.adcio_agent_compose.provider

var composeProductId = ""

class ComposeWebViewManager {
    private lateinit var delayedString: String

    fun setDelayedString(value: String) {
        delayedString = value
    }

    fun getDelayedString(): String {
        if (!::delayedString.isInitialized) {
            throw IllegalStateException("Delayed string is not initialized yet.")
        }
        return delayedString
    }

    fun emptyProductId() {
        composeProductId = ""
    }

    fun getProductId(id: String) {
        composeProductId = id
    }
}