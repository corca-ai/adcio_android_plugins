package ai.corca.adcio_agent.agent

import ai.corca.adcio_agent.R
import ai.corca.adcio_agent.provider.AdcioAgent
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface AgentPageManager {
    fun isAgentStartPage(): Boolean

    fun agentGoBack(): Boolean
}

internal class AgentClient : Fragment(R.layout.fragment_adcio_agent) {

    internal var webView: WebView? = null
    private lateinit var callback: OnBackPressedCallback
    internal var pageManager = AgentPageManagerImpl()

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

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val agentUrl = arguments?.getString("agentUrl") ?: ""
        webView = view.findViewById(R.id.webView)

        webView?.apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                javaScriptCanOpenWindowsAutomatically = false
            }
            addJavascriptInterface(ProductRouterJavascriptInterface(), "ProductRouter")
            webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView?,
                    url: String?,
                    message: String?,
                    result: android.webkit.JsResult?
                ): Boolean {
                    ProductRouterJavascriptInterface().postMessage(message!!)
                    return super.onJsAlert(view, url, message, result)
                }
            }

            loadUrl(agentUrl)
            pageManager = AgentPageManagerImpl()
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (pageManager.agentGoBack()) {  // webView?.canGoBack() == true인 경우
                    webView?.goBack()
                    Log.d("goBack", "너의 전화는")
                } else {  // webView?.canGoBack() == false인 경우
                    isEnabled = false  // 현재 콜백 비활성화
                    requireActivity().finish()  // Activity의 onBackPressed 메서드 호출
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, callback)  // 콜백 등록
    }



    private inner class ProductRouterJavascriptInterface {
        @JavascriptInterface

        fun postMessage(productId: String) {
            AdcioAgent(
                context = requireContext().applicationContext,
                clientId = "",
                "",
                0
            ).setProductId(productId)
        }
    }

    inner class AgentPageManagerImpl : AgentPageManager {

        override fun isAgentStartPage(): Boolean {
            return webView?.url?.contains("start/") == true
        }

        override fun agentGoBack(): Boolean {
            return webView?.canGoBack() == true
        }
    }
}


