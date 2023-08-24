package ai.corca.adcio_android_plugins.placement

import ai.corca.adcio_android_plugins.databinding.ActivityPlacementBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PlacementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacementBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}