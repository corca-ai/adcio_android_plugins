package ai.corca.adcio_android_plugins.agent.ui

import ai.corca.adcio_agent.provider.AdcioAgent
import ai.corca.adcio_agent.provider.AdcioAgentListener
import ai.corca.adcio_agent.provider.adcioAgentListener
import ai.corca.adcio_android_plugins.R
import ai.corca.adcio_android_plugins.databinding.ActivityXmlBinding
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class XmlActivity : AppCompatActivity() {

    lateinit var binding: ActivityXmlBinding

    private val agent = AdcioAgent(
        context = this,
        clientId = "30cb6fd0-17a5-4c56-b144-fef67de81bef",
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


        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            agent.agentGoBack()
        }
    }
}
