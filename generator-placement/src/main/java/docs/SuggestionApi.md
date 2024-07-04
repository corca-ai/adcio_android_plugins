# SuggestionApi

All URIs are relative to *https://api.adcio.ai*

Method | HTTP request | Description
------------- | ------------- | -------------
[**advertisementsControllerAdvertiseBanners**](SuggestionApi.md#advertisementsControllerAdvertiseBanners) | **POST** v1/advertisements/banners | 
[**advertisementsControllerAdvertiseProducts**](SuggestionApi.md#advertisementsControllerAdvertiseProducts) | **POST** v1/advertisements/products | 
[**recommendationsControllerRecommendBanners**](SuggestionApi.md#recommendationsControllerRecommendBanners) | **POST** v1/recommendations/banners | 
[**recommendationsControllerRecommendProducts**](SuggestionApi.md#recommendationsControllerRecommendProducts) | **POST** v1/recommendations/products | 
[**suggestionControllerAdvertiseBanners**](SuggestionApi.md#suggestionControllerAdvertiseBanners) | **POST** advertisements/banners | 
[**suggestionControllerAdvertiseProducts**](SuggestionApi.md#suggestionControllerAdvertiseProducts) | **POST** advertisements/products | 
[**suggestionControllerRecommendBanners**](SuggestionApi.md#suggestionControllerRecommendBanners) | **POST** recommendations/banners | 
[**suggestionControllerRecommendProducts**](SuggestionApi.md#suggestionControllerRecommendProducts) | **POST** recommendations/products | 





Fetch a personalized banner for advertisement.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SuggestionApi::class.java)
val bannerSuggestionRequestDto : BannerSuggestionRequestDto =  // BannerSuggestionRequestDto | 

launch(Dispatchers.IO) {
    val result : BannerSuggestionResponseDto = webService.advertisementsControllerAdvertiseBanners(bannerSuggestionRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bannerSuggestionRequestDto** | [**BannerSuggestionRequestDto**](BannerSuggestionRequestDto.md)|  |

### Return type

[**BannerSuggestionResponseDto**](BannerSuggestionResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Fetch a personalized product for advertisement.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SuggestionApi::class.java)
val productSuggestionRequestDto : ProductSuggestionRequestDto =  // ProductSuggestionRequestDto | 

launch(Dispatchers.IO) {
    val result : ProductSuggestionResponseDto = webService.advertisementsControllerAdvertiseProducts(productSuggestionRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productSuggestionRequestDto** | [**ProductSuggestionRequestDto**](ProductSuggestionRequestDto.md)|  |

### Return type

[**ProductSuggestionResponseDto**](ProductSuggestionResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Fetch a personalized banner for recommendation.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SuggestionApi::class.java)
val bannerSuggestionRequestDto : BannerSuggestionRequestDto =  // BannerSuggestionRequestDto | 

launch(Dispatchers.IO) {
    val result : BannerSuggestionResponseDto = webService.recommendationsControllerRecommendBanners(bannerSuggestionRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bannerSuggestionRequestDto** | [**BannerSuggestionRequestDto**](BannerSuggestionRequestDto.md)|  |

### Return type

[**BannerSuggestionResponseDto**](BannerSuggestionResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Fetch a personalized product for recommendation.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SuggestionApi::class.java)
val productSuggestionRequestDto : ProductSuggestionRequestDto =  // ProductSuggestionRequestDto | 

launch(Dispatchers.IO) {
    val result : ProductSuggestionResponseDto = webService.recommendationsControllerRecommendProducts(productSuggestionRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productSuggestionRequestDto** | [**ProductSuggestionRequestDto**](ProductSuggestionRequestDto.md)|  |

### Return type

[**ProductSuggestionResponseDto**](ProductSuggestionResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Fetch a personalized banner for advertisement.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SuggestionApi::class.java)
val bannerSuggestionRequestDto : BannerSuggestionRequestDto =  // BannerSuggestionRequestDto | 

launch(Dispatchers.IO) {
    val result : BannerSuggestionResponseDto = webService.suggestionControllerAdvertiseBanners(bannerSuggestionRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bannerSuggestionRequestDto** | [**BannerSuggestionRequestDto**](BannerSuggestionRequestDto.md)|  |

### Return type

[**BannerSuggestionResponseDto**](BannerSuggestionResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Fetch a personalized product for advertisement.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SuggestionApi::class.java)
val productSuggestionRequestDto : ProductSuggestionRequestDto =  // ProductSuggestionRequestDto | 

launch(Dispatchers.IO) {
    val result : ProductSuggestionResponseDto = webService.suggestionControllerAdvertiseProducts(productSuggestionRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productSuggestionRequestDto** | [**ProductSuggestionRequestDto**](ProductSuggestionRequestDto.md)|  |

### Return type

[**ProductSuggestionResponseDto**](ProductSuggestionResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Fetch a personalized banner for recommendation.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SuggestionApi::class.java)
val bannerSuggestionRequestDto : BannerSuggestionRequestDto =  // BannerSuggestionRequestDto | 

launch(Dispatchers.IO) {
    val result : BannerSuggestionResponseDto = webService.suggestionControllerRecommendBanners(bannerSuggestionRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bannerSuggestionRequestDto** | [**BannerSuggestionRequestDto**](BannerSuggestionRequestDto.md)|  |

### Return type

[**BannerSuggestionResponseDto**](BannerSuggestionResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Fetch a personalized product for recommendation.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SuggestionApi::class.java)
val productSuggestionRequestDto : ProductSuggestionRequestDto =  // ProductSuggestionRequestDto | 

launch(Dispatchers.IO) {
    val result : ProductSuggestionResponseDto = webService.suggestionControllerRecommendProducts(productSuggestionRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productSuggestionRequestDto** | [**ProductSuggestionRequestDto**](ProductSuggestionRequestDto.md)|  |

### Return type

[**ProductSuggestionResponseDto**](ProductSuggestionResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

