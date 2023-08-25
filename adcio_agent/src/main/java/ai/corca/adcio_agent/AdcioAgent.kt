package ai.corca.adcio_agent

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class AdcioAgentActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adcio_agent) // Replace with your layout resource

        val agentUrl = intent.getStringExtra("agentUrl")!!
        webView = findViewById(R.id.webView) // Replace with your WebView ID from XML layout

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

    private inner class ProductRouterJavascriptInterface {
        @JavascriptInterface
        fun postMessage(productId: String) {
            WebViewManager(
                context = applicationContext,
                clientId = "",
                "",
            ).getProductId(productId)
            runOnUiThread {
                finish()
            }
        }
    }
}
