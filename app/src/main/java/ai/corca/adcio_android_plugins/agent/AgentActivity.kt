package ai.corca.adcio_android_plugins.agent

import ai.corca.adcio_android_plugins.databinding.ActivityAgentBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AgentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}