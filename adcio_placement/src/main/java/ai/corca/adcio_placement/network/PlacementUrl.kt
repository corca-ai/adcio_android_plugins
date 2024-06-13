package ai.corca.adcio_placement.network

internal object PlacementUrl {

    var baseUrl: String = "https://api.adcio.ai/"

    object EndPoint {
        const val recProducts = "v1/recommendations/products"
        const val recBanners = "v1/recommendations/banners"
        const val adBanners = "v1/advertisements/banners"
        const val adProducts = "v1/advertisements/products"
    }
}
