package ai.corca.adcio_agent

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class AdcioAgent : Fragment(R.layout.fragment_adcio_agent) {

    private lateinit var webView: WebView
    private lateinit var callback: OnBackPressedCallback

    companion object {
        private const val ARG_AGENT_URL = "agentUrl"

        fun newInstance(agentUrl: String): AdcioAgent {
            val fragment = AdcioAgent()
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

        webView.apply {
            settings.javaScriptEnabled = true
            addJavascriptInterface(ProductRouterJavascriptInterface(), "ProductRouter")
            webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(view: WebView?, url: String?, message: String?, result: android.webkit.JsResult?): Boolean {
                    ProductRouterJavascriptInterface().postMessage(message!!)
                    return super.onJsAlert(view, url, message, result)
                }
            }
            loadUrl(agentUrl)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    private inner class ProductRouterJavascriptInterface {
        @JavascriptInterface
        fun postMessage(productId: String) {
            WebViewManager(
                context = requireContext().applicationContext,
                clientId = "",
                "",
                0
            ).getProductId(productId)
            requireActivity().runOnUiThread {
                requireActivity().finish()
            }
        }
    }
}
