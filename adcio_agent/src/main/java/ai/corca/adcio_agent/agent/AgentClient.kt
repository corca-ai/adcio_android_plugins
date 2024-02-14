package ai.corca.adcio_agent.agent

import ai.corca.adcio_agent.R
import ai.corca.adcio_agent.provider.AdcioAgent
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

internal class AgentClient : Fragment(R.layout.fragment_adcio_agent) {

    internal var pageManager: AgentPageManager? = null
    private lateinit var callback: OnBackPressedCallback

    internal companion object {
        private const val ARG_AGENT_URL = "agentUrl"

        fun newInstance(agentUrl: String): AgentClient {
            val fragment = AgentClient()
            val args = Bundle().apply {
                putString(ARG_AGENT_URL, agentUrl)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (pageManager?.agentGoBack() == true) {
                    Log.d("goBack", "WebView goes back.")
                } else {
                    isEnabled = false
                    requireActivity().finish()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback) // register callback
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val agentUrl = arguments?.getString(ARG_AGENT_URL) ?: ""
        val webView = view.findViewById<WebView>(R.id.webView)

        pageManager = WebViewManager(webView, agentUrl)
    }

    interface AgentPageManager {
        fun isAgentStartPage(): Boolean

        fun agentGoBack(): Boolean
    }

    private inner class ProductRouterJavascriptInterface {
        @JavascriptInterface
        fun postMessage(productId: String) {
            AdcioAgent(
                context = requireContext().applicationContext,
                clientId = "",
                baseUrl = "",
                fragmentContainer = 0
            ).setProductId(productId)
        }
    }

    /**
     * Implementation of Agent management functions
     */
    @SuppressLint("SetJavaScriptEnabled")
    inner class WebViewManager(private val webView: WebView, agentUrl: String) : AgentPageManager {

        init {
            webView.apply {
                settings.apply {
                    // Webview permission settings
                    javaScriptEnabled = true
                    domStorageEnabled = true
                    javaScriptCanOpenWindowsAutomatically = false
                }
                loadUrl(agentUrl)
            }
            webView.addJavascriptInterface(ProductRouterJavascriptInterface(), "ProductRouter")
        }

        override fun isAgentStartPage(): Boolean {
            return webView.url?.contains("start/") ?: false
        }

        override fun agentGoBack(): Boolean {
            return if (webView.canGoBack()) {
                webView.goBack()
                true
            } else {
                false
            }
        }
    }
}
