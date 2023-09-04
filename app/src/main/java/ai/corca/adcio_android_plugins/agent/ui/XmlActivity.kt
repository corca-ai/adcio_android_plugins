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

    private val agent = AdcioAgent(
        context = this,
        clientId = "YOUR_CLIENT_ID",
        fragmentContainer = R.id.adcio_agent_frame,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        agent.callAdcioAgent()

        adcioAgentListener = object : AdcioAgentListener {
            override fun onClickProductId(productId: String) {
                /**
                 * An example of a Toast for productId.
                 */
                Toast.makeText(this@XmlActivity, productId, Toast.LENGTH_SHORT).show()

                /**
                 * An example of screen movement for productId.
                 */
                val intent = Intent(this@XmlActivity, SecondActivity::class.java)
                intent.putExtra("productId", productId)
                startActivity(intent)
            }
        }

        if (agent.isAgentStartPage()) {
            print(true)
        } else print(false)

        binding.btnBack.setOnClickListener {
            /**
             * Important: If you use the app's own AppBar to enable POP of the AppBar's WebView,
             * You must enable the following settings: onBackPressedDispatcher.onBackPressed()
             */
            onBackPressedDispatcher.onBackPressed() // IMPORTANT THING TO DO
            agent.agentGoBack() // Agent move back page
        }
    }
}
