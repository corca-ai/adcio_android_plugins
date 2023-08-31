package ai.corca.adcio_android_plugins.usecases.mockapp.fragment

import ai.corca.adcio_android_plugins.databinding.FragmentRecommendBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class RecommendFragment : Fragment() {

    private lateinit var binding: FragmentRecommendBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecommendBinding.inflate(
            inflater,
            container,
            false,
        )
        return binding.root
    }
}
