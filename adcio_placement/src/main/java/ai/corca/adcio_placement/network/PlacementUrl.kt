package ai.corca.adcio_placement.network

internal object PlacementUrl {

    var baseUrl: String = "https://api.adcio.ai/"

    object EndPoint {
        const val recProducts = "recommendations/products"
        const val adBanners = "advertisements/banners"
        const val adProducts = "advertisements/products"
        const val recBanners = "recommendations/banners"
    }
}
