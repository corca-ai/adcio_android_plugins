package ai.corca.adcio_android_plugins

import ai.corca.adcio_android_plugins.agent.AgentActivity
import ai.corca.adcio_android_plugins.databinding.ActivityMainBinding
import ai.corca.adcio_android_plugins.suggestion.SuggestionActivity
import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager.PackageInfoFlags
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.amplitude.api.Amplitude
import com.amplitude.api.AmplitudeLog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
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
