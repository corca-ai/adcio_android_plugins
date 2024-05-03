package ai.corca.adcio_placement.mapper

import ai.corca.adcio_placement.model.banner.Banner
import ai.corca.adcio_placement.network.data.response.banner.BannerData

internal fun BannerData.toBanner(): Banner = Banner(
    id = this.id,
    clientId = this.clientId,
    creative = this.creative,
    name = this.name,
    url = this.url,
    categoryId = this.categoryId,
    productId = this.productId,
    activated = this.activated,
    startsAt = this.startsAt,
    endsAt = this.endsAt,
    createdAt = this.createdAt,
    deletedAt = this.deletedAt,
)

internal fun Banner.toBannerData(): BannerData = BannerData(
    id = this.id,
    clientId = this.clientId,
    creative = this.creative,
    name = this.name,
    url = this.url,
    categoryId = this.categoryId,
    productId = this.productId,
    activated = this.activated,
    startsAt = this.startsAt,
    endsAt = this.endsAt,
    createdAt = this.createdAt,
    deletedAt = this.deletedAt,
)
