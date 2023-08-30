package ai.corca.adcio_android_plugins.usecases.mockapp.fragment

import ai.corca.adcio_android_plugins.databinding.FragmentListBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(
            inflater,
            container,
            false,
        )
        return binding.root
    }
}
