package ai.corca.adcio_android_plugins.core

import ai.corca.adcio_android_plugins.databinding.ActivityCoreBinding
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.corcaai.core.ids.SessionClient
import com.corcaai.core.ids.loadDeviceId

class CoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // You can get your registered device ID.
        // ex) TP1A.220612.012
        // You can also change the registered DeviceID value through the otherInfo parameter.
        val deviceId = loadDeviceId()

        // You can get your registered session ID!
        // ex) 70828121-1234-47d71-fh71-fy71j47s83jd
        // You can also change the registered SessionID value through the info parameter.
        val sessionId = SessionClient.loadSessionId()

        binding.tvDeviceId.setOnClickListener {
            Toast.makeText(this, "Device Id: $deviceId", Toast.LENGTH_SHORT).show()
        }

        binding.tvSessionId.setOnClickListener {
            Toast.makeText(this, "Session Id: $sessionId", Toast.LENGTH_SHORT).show()
        }
    }
}
