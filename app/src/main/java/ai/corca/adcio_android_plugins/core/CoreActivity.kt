package ai.corca.adcio_android_plugins.core

import ai.corca.adcio_android_plugins.databinding.ActivityCoreBinding
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.corcaai.adcio_core.feature.AdcioCore

class CoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // You can get your registered device ID.
        // ex) TP1A.220612.012
        // You can also change the registered DeviceID value through the otherInfo parameter.
        val deviceId = AdcioCore.deviceId

        // You can get your registered session ID!
        // ex) 70828121-1234-47d71-fh71-fy71j47s83jd
        // You can also change the registered SessionID value through the info parameter.
        val sessionId = AdcioCore.sessionId

        binding.tvClientId.setOnClickListener {
            val clientId = AdcioCore.clientId
            Toast.makeText(this, "Client Id: $clientId", Toast.LENGTH_SHORT).show()
        }

        binding.tvDeviceId.setOnClickListener {
            Toast.makeText(this, "Device Id: $deviceId", Toast.LENGTH_SHORT).show()
        }

        binding.tvSessionId.setOnClickListener {
            Toast.makeText(this, "Session Id: $sessionId", Toast.LENGTH_SHORT).show()
        }
    }
}
