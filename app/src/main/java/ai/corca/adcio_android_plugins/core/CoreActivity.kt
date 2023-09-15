package ai.corca.adcio_android_plugins.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ai.corca.adcio_android_plugins.R
import ai.corca.adcio_android_plugins.databinding.ActivityCoreBinding
import ai.corca.adcio_placement.feature.AdcioPlacement
import android.widget.Toast
import com.corcaai.adcio_core.feature.AdcioInfo

class CoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoreBinding

    // You can get your registered device ID.
    // ex) TP1A.220612.012
    // You can also change the registered DeviceID value through the otherInfo parameter.
    private val deviceId = AdcioInfo.getDeviceId()

    // You can get your registered session ID!
    // ex) 70828121-1234-47d71-fh71-fy71j47s83jd
    // You can also change the registered SessionID value through the info parameter.
    private val sessionId = AdcioInfo.getSessionId()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // You should init to use getClientId
        // Also you must init any parts that use ClientId in the placement or analytics module.
        AdcioInfo.init("67592c00-a230-4c31-902e-82ae4fe71866")

        binding.tvClientId.setOnClickListener {
            val clientId = AdcioInfo.getClientId()
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