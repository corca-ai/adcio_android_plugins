package ai.corca.adcio_android_plugins.usecases.mockapp.fragment

import ai.corca.adcio_analytics.feature.AdcioAnalytics
import ai.corca.adcio_android_plugins.databinding.FragmentHomeBinding
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.CategoryAdapter
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.ProductAdapter
import ai.corca.adcio_android_plugins.usecases.mockapp.utils.sampleProducts
import ai.corca.adcio_android_plugins.usecases.mockapp.vm.HomeViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productAdapter: ProductAdapter
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false,
        )
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        initView()
        getData()
        return binding.root
    }

    private fun initView() {
        binding.ivRefresh.setOnClickListener {
            homeViewModel.getProducts()
        }
        categoryAdapter = CategoryAdapter()
        binding.rvCategory.adapter = categoryAdapter
        categoryAdapter.submitList(listOf("럭셔리", "뷰티", "스포츠", "아울렛", "키즈", "골프", "어스", "패션톡"))

        productAdapter = ProductAdapter { logOption ->
            CoroutineScope(Dispatchers.IO).launch {
                AdcioAnalytics.onClick(
                    option = logOption
                )
            }
        }
        binding.rvProduct.adapter = productAdapter
    }

    private fun getData() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            homeViewModel.suggestionState.collect { products ->
                if (products.isNotEmpty()) {
                    val myProducts = (products + sampleProducts).shuffled()
                    productAdapter.submitList(myProducts)
                }
            }
        }
    }
}
