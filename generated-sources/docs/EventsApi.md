# EventsApi

All URIs are relative to *https://receiver.adcio.ai*

Method | HTTP request | Description
------------- | ------------- | -------------
[**eventsControllerOnAddToCart**](EventsApi.md#eventsControllerOnAddToCart) | **POST** events/add-to-cart | 
[**eventsControllerOnClick**](EventsApi.md#eventsControllerOnClick) | **POST** events/click | 
[**eventsControllerOnImpression**](EventsApi.md#eventsControllerOnImpression) | **POST** events/impression | 
[**eventsControllerOnPageView**](EventsApi.md#eventsControllerOnPageView) | **POST** events/view | 
[**eventsControllerOnPurchase**](EventsApi.md#eventsControllerOnPurchase) | **POST** events/purchase | 





Log when the customer adds a product to the cart.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_analytics.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(EventsApi::class.java)
val trackAddToCartRequestDto : TrackAddToCartRequestDto =  // TrackAddToCartRequestDto | 

launch(Dispatchers.IO) {
    val result : TrackResponseDto = webService.eventsControllerOnAddToCart(trackAddToCartRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **trackAddToCartRequestDto** | [**TrackAddToCartRequestDto**](TrackAddToCartRequestDto.md)|  |

### Return type

[**TrackResponseDto**](TrackResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Log a click.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_analytics.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(EventsApi::class.java)
val trackClickRequestDto : TrackClickRequestDto =  // TrackClickRequestDto | 

launch(Dispatchers.IO) {
    val result : TrackResponseDto = webService.eventsControllerOnClick(trackClickRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **trackClickRequestDto** | [**TrackClickRequestDto**](TrackClickRequestDto.md)|  |

### Return type

[**TrackResponseDto**](TrackResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Log an impression.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_analytics.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(EventsApi::class.java)
val trackImpressionRequestDto : TrackImpressionRequestDto =  // TrackImpressionRequestDto | 

launch(Dispatchers.IO) {
    val result : TrackResponseDto = webService.eventsControllerOnImpression(trackImpressionRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **trackImpressionRequestDto** | [**TrackImpressionRequestDto**](TrackImpressionRequestDto.md)|  |

### Return type

[**TrackResponseDto**](TrackResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Log when the customer views a specific product / category page.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_analytics.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(EventsApi::class.java)
val trackPageViewRequestDto : TrackPageViewRequestDto =  // TrackPageViewRequestDto | 

launch(Dispatchers.IO) {
    val result : TrackResponseDto = webService.eventsControllerOnPageView(trackPageViewRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **trackPageViewRequestDto** | [**TrackPageViewRequestDto**](TrackPageViewRequestDto.md)|  |

### Return type

[**TrackResponseDto**](TrackResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Log when the customer purchases a product.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_analytics.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(EventsApi::class.java)
val trackPurchaseRequestDto : TrackPurchaseRequestDto =  // TrackPurchaseRequestDto | 

launch(Dispatchers.IO) {
    val result : TrackResponseDto = webService.eventsControllerOnPurchase(trackPurchaseRequestDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **trackPurchaseRequestDto** | [**TrackPurchaseRequestDto**](TrackPurchaseRequestDto.md)|  |

### Return type

[**TrackResponseDto**](TrackResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

