package ai.corca.adcio_placement.mapper

import ai.corca.adcio_placement.model.Product
import ai.corca.adcio_placement.network.data.ProductData

internal fun ProductData.toProduct(): Product = Product(
    id = this.id,
    code = this.code,
    storeId = this.storeId,
    sellerId = this.sellerId,
    name = this.name,
    price = this.price,
    description = this.description,
    image = this.image,
    includeInRecommendation = this.includeInRecommendation,
    url = this.url,
    deepLink = this.deepLink,
    caption = this.caption,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
)

internal fun Product.toProductData(): ProductData = ProductData(
    id = this.id,
    code = this.code,
    storeId = this.storeId,
    sellerId = this.sellerId,
    name = this.name,
    price = this.price,
    description = this.description,
    image = this.image,
    includeInRecommendation = this.includeInRecommendation,
    url = this.url,
    deepLink = this.deepLink,
    caption = this.caption,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
)
