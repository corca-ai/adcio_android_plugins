# PlacementApi

All URIs are relative to *https://api.adcio.ai*

Method | HTTP request | Description
------------- | ------------- | -------------
[**placementControllerConnectProducts**](PlacementApi.md#placementControllerConnectProducts) | **POST** placements/{id}/products | 
[**placementControllerCreate**](PlacementApi.md#placementControllerCreate) | **POST** placements | 
[**placementControllerFetchMany**](PlacementApi.md#placementControllerFetchMany) | **GET** placements | 
[**placementControllerFetchOne**](PlacementApi.md#placementControllerFetchOne) | **GET** placements/{id} | 
[**placementControllerRemove**](PlacementApi.md#placementControllerRemove) | **DELETE** placements/{id} | 
[**placementControllerRemoveProduct**](PlacementApi.md#placementControllerRemoveProduct) | **DELETE** placements/{id}/products/{productId} | 
[**placementControllerUpdate**](PlacementApi.md#placementControllerUpdate) | **PATCH** placements/{id} | 





### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PlacementApi::class.java)
val id : kotlin.String = id_example // kotlin.String | 
val connectProductsToPlacementDto : ConnectProductsToPlacementDto =  // ConnectProductsToPlacementDto | 

launch(Dispatchers.IO) {
    val result : ConnectProductsToPlacementResponseDto = webService.placementControllerConnectProducts(id, connectProductsToPlacementDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **connectProductsToPlacementDto** | [**ConnectProductsToPlacementDto**](ConnectProductsToPlacementDto.md)|  |

### Return type

[**ConnectProductsToPlacementResponseDto**](ConnectProductsToPlacementResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PlacementApi::class.java)
val createPlacementDto : CreatePlacementDto =  // CreatePlacementDto | 

launch(Dispatchers.IO) {
    val result : Placement = webService.placementControllerCreate(createPlacementDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createPlacementDto** | [**CreatePlacementDto**](CreatePlacementDto.md)|  |

### Return type

[**Placement**](Placement.md)

### Authorization



### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PlacementApi::class.java)
val orderBy : kotlin.collections.List<kotlin.String> = ["title:ASC","title:DESC","createdAt:ASC","createdAt:DESC","activated:ASC","activated:DESC","type:ASC","type:DESC","supportEnvironment:ASC","supportEnvironment:DESC","storeName:ASC","storeName:DESC"] // kotlin.collections.List<kotlin.String> | PlacementSortOption
val select : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val title : kotlin.String = title_example // kotlin.String | 
val startDate : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val endDate : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val type : kotlin.String = type_example // kotlin.String | 
val suggestionType : kotlin.String = suggestionType_example // kotlin.String | 
val activated : kotlin.Boolean = true // kotlin.Boolean | 
val limit : java.math.BigDecimal = 8.14 // java.math.BigDecimal | 
val offset : java.math.BigDecimal = 8.14 // java.math.BigDecimal | 

launch(Dispatchers.IO) {
    val result : PlacementControllerFetchMany200Response = webService.placementControllerFetchMany(orderBy, select, title, startDate, endDate, type, suggestionType, activated, limit, offset)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderBy** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| PlacementSortOption | [optional]
 **select** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: id, title, type, suggestionType, displayCount, activated, pageName, clientId, injector, screenShot, displayFormatWidth, displayFormatHeight, property, placementFormatRatio, createdAt, updatedAt, deletedAt]
 **title** | **kotlin.String**|  | [optional]
 **startDate** | **java.time.OffsetDateTime**|  | [optional]
 **endDate** | **java.time.OffsetDateTime**|  | [optional]
 **type** | **kotlin.String**|  | [optional] [enum: GRID, BANNER]
 **suggestionType** | **kotlin.String**|  | [optional] [enum: RECOMMEND, ADVERTISE]
 **activated** | **kotlin.Boolean**|  | [optional]
 **limit** | **java.math.BigDecimal**|  | [optional]
 **offset** | **java.math.BigDecimal**|  | [optional]

### Return type

[**PlacementControllerFetchMany200Response**](PlacementControllerFetchMany200Response.md)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json




### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PlacementApi::class.java)
val id : kotlin.String = id_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : FetchPlacementResponseDto = webService.placementControllerFetchOne(id)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

[**FetchPlacementResponseDto**](FetchPlacementResponseDto.md)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json




### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PlacementApi::class.java)
val id : kotlin.String = id_example // kotlin.String | 

launch(Dispatchers.IO) {
    webService.placementControllerRemove(id)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json




### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PlacementApi::class.java)
val id : kotlin.String = id_example // kotlin.String | 
val productId : kotlin.String = productId_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RemoveProductFromPlacementResponseDto = webService.placementControllerRemoveProduct(id, productId)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **productId** | **kotlin.String**|  |

### Return type

[**RemoveProductFromPlacementResponseDto**](RemoveProductFromPlacementResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json




### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PlacementApi::class.java)
val id : kotlin.String = id_example // kotlin.String | 
val updatePlacementDto : UpdatePlacementDto =  // UpdatePlacementDto | 

launch(Dispatchers.IO) {
    val result : UpdatePlacementResponseDto = webService.placementControllerUpdate(id, updatePlacementDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **updatePlacementDto** | [**UpdatePlacementDto**](UpdatePlacementDto.md)|  |

### Return type

[**UpdatePlacementResponseDto**](UpdatePlacementResponseDto.md)

### Authorization



### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

