package ai.corca.adcio_android_plugins

import ai.corca.adcio_android_plugins.agent.AgentActivity
import ai.corca.adcio_android_plugins.databinding.ActivityMainBinding
import ai.corca.adcio_android_plugins.suggestion.SuggestionActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgent.setOnClickListener {
            val intent = Intent(this, AgentActivity::class.java)
            startActivity(intent)
        }

        binding.btnPlacement.setOnClickListener {
            val intent = Intent(this, SuggestionActivity::class.java)
            startActivity(intent)
        }
    }
}
