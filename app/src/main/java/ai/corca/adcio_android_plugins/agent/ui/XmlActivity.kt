package ai.corca.adcio_android_plugins.agent.ui

import ai.corca.adcio_agent.provider.AdcioAgent
import ai.corca.adcio_agent.provider.AdcioAgentListener
import ai.corca.adcio_agent.provider.adcioAgentListener
import ai.corca.adcio_android_plugins.R
import ai.corca.adcio_android_plugins.databinding.ActivityXmlBinding
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class XmlActivity : AppCompatActivity() {

    lateinit var binding: ActivityXmlBinding

    // init AdcioAgent Entity
    // input context, client, fragmentContainer (<ai.corca.adcio_agent.layout.AdcioAgentLayout>)
    private val agent = AdcioAgent(
        context = this,
        clientId = "67592c00-a230-4c31-902e-82ae4fe71866",
        fragmentContainer = R.id.adcio_agent_frame,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        agent.callAdcioAgent()

        adcioAgentListener = object : AdcioAgentListener {
            override fun onClickProduct(productId: String) {
                // Below is the code that deals with the productId we received.
                // The important point is that you can get and use productId.

                // Example of a Toast for productId.
                Toast.makeText(this@XmlActivity, productId, Toast.LENGTH_SHORT).show()

                // Another example of screen movement for productId.
                val intent = Intent(this@XmlActivity, SecondActivity::class.java)
                intent.putExtra("productId", productId)
                startActivity(intent)
            }
        }

        // you can check agent web is start page!
        // if (agent.isAgentStartPage()) {
        //    // if agent web page is start page.
        // }

        binding.btnBack.setOnClickListener {
            // Important: If you use the app's own AppBar to enable POP of the AppBar's WebView,
            // You must enable the following settings: onBackPressedDispatcher.onBackPressed()
            onBackPressedDispatcher.onBackPressed() // IMPORTANT THING TO DO
            agent.agentGoBack() // Agent move back page
        }
    }
}
