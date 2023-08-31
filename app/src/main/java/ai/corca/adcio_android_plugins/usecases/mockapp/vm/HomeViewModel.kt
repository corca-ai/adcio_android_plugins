package ai.corca.adcio_android_plugins.usecases.mockapp.vm

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.usecases.mockapp.adapter.model.Product
import ai.corca.adcio_placement.feature.AdcioPlacement
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _suggestionState = MutableStateFlow(emptyList<Product>())
    val suggestionState: StateFlow<List<Product>> = _suggestionState

    init {
        getProducts()
    }

    fun getProducts() = viewModelScope.launch(Dispatchers.IO) {
        val products = mutableListOf<Product>()
        val result = AdcioPlacement.adcioSuggest(
            placementId = "9f9f9b00-dc16-41c7-a5cd-f9a788d3d481",
        )
        result.suggestions.forEach {
            products.add(
                Product(
                    productId = it.product.id,
                    isAd = true,
                    name = it.product.name,
                    image = it.product.image,
                    brand = "SanSanGear",
                    sale = "30",
                    price = it.product.price.toString(),
                    logOption = AdcioLogOption(
                        requestId = it.logOptions.requestId,
                        adsetId = it.logOptions.adsetId
                    )
                )
            )
        }

        _suggestionState.value = products
    }
}
