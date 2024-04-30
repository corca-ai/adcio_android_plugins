package ai.corca.adcio_placement.mapper

import ai.corca.adcio_placement.model.banner.AdcioSuggestionBanner
import ai.corca.adcio_placement.model.product.AdcioSuggestionProduct
import ai.corca.adcio_placement.network.data.response.banner.AdcioSuggestionBannerData
import ai.corca.adcio_placement.network.data.response.product.AdcioSuggestionProductData

internal fun AdcioSuggestionBanner.toAdcioSuggestionBannerData(): AdcioSuggestionBannerData = AdcioSuggestionBannerData(
    bannerData = this.banner?.toBannerData(),
    logOptionsData = this.logOptions.toBannerLogOptionsData(),
)

internal fun AdcioSuggestionBannerData.toAdcioSuggestionBanner(): AdcioSuggestionBanner = AdcioSuggestionBanner(
    banner = this.bannerData?.toBanner(),
    logOptions = this.logOptionsData.toLogOptions(),
)

internal fun AdcioSuggestionProduct.toAdcioSuggestionProductData(): AdcioSuggestionProductData = AdcioSuggestionProductData(
    logOptionsData = this.logOptions.toProductLogOptionsData(),
    productData = this.product.toProductData()
)

internal fun AdcioSuggestionProductData.toAdcioSuggestionProduct(): AdcioSuggestionProduct = AdcioSuggestionProduct(
    logOptions = this.logOptionsData.toLogOptions(),
    product = this.productData.toProduct()
)
