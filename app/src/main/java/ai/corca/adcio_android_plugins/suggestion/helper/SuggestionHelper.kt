package ai.corca.adcio_android_plugins.suggestion.helper

import ai.corca.adcio_analytics.AdcioLogOption
import ai.corca.adcio_android_plugins.suggestion.currentUser
import ai.corca.adcio_android_plugins.suggestion.model.Production
import ai.corca.adcio_android_plugins.suggestion.utils.clearImpressionHistory
import ai.corca.adcio_android_plugins.suggestion.utils.getMockProducts
import ai.corca.adcio_placement.AdcioPlacement
import ai.corca.placement.model.ProductFilterOperationDto
import ai.corca.placement.model.ProductSuggestionResponseDto
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking

private val _productState = MutableStateFlow(emptyList<Production>())
val productions: StateFlow<List<Production>> = _productState

internal class GetSuggestionThread : Thread() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun run() {
        val adcioSuggestionRaw = runBlocking {
            AdcioPlacement.createAdvertisementProducts(
                clientId = "76dc12fa-5a73-4c90-bea5-d6578f9bc606",
                placementId = "5ae9907f-3cc2-4ed4-aaa4-4b20ac97f9f4",
                categoryId = "2179",
                excludingProductIds = listOf("1001"),
                customerId = currentUser.id,
                filters = mapOf(
                    "price_excluding_tax" to ProductFilterOperationDto(not = 53636),
                    "product_code" to ProductFilterOperationDto(contains = "KY"),
                    "province_id" to ProductFilterOperationDto(equalTo = 1)
                ),
            )
        }

        // Clear impression history when suggestion api called
        clearImpressionHistory()

        if (adcioSuggestionRaw != null) {
            handleResultData(adcioSuggestionRaw)
        }
    }
}

@SuppressLint("NotifyDataSetChanged")
fun handleResultData(adcioSuggestionRaw: ProductSuggestionResponseDto) {
    val products: MutableList<Production> = getMockProducts().toMutableList()

    adcioSuggestionRaw.suggestions.forEach {
        products.add(
            Production(
                productId = it.product.idOnStore, // product.code = product id of client service
                name = it.product.name,
                image = it.product.image,
                price = it.product.price.toString(),
                logOption = AdcioLogOption(
                    requestId = it.logOptions.requestId,
                    adsetId = it.logOptions.adsetId
                ),
                isSuggested = true
            )
        )
    }

    _productState.value = products
}