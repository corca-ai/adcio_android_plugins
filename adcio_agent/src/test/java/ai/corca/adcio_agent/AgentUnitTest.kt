package ai.corca.adcio_agent

import ai.corca.adcio_agent.provider.WebViewManager
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AgentUnitTest {
    @Test
    fun productId_isFetched() {

        val webViewManager = WebViewManager(
            context = null,
            clientId = "",
            "",
            0
        )

        webViewManager.apply {
            setDelayedString("productId")
            assertEquals(getDelayedString(), "productId")
        }
    }
}
