# ProductApi

All URIs are relative to *https://api.adcio.ai*

Method | HTTP request | Description
------------- | ------------- | -------------
[**productControllerCreate**](ProductApi.md#productControllerCreate) | **POST** products | 
[**productControllerFetchMany**](ProductApi.md#productControllerFetchMany) | **GET** products | 
[**productControllerFetchOne**](ProductApi.md#productControllerFetchOne) | **GET** products/{id} | 
[**productControllerUpdate**](ProductApi.md#productControllerUpdate) | **PATCH** products/{id} | 
[**productControllerUpsertMany**](ProductApi.md#productControllerUpsertMany) | **PUT** products/bulk | 





### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductApi::class.java)
val createProductDto : CreateProductDto =  // CreateProductDto | 

launch(Dispatchers.IO) {
    val result : Product = webService.productControllerCreate(createProductDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createProductDto** | [**CreateProductDto**](CreateProductDto.md)|  |

### Return type

[**Product**](Product.md)

### Authorization



### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Fetch many products.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductApi::class.java)
val orderBy : kotlin.collections.List<kotlin.String> = ["name:ASC","name:DESC","id:ASC","id:DESC","idOnStore:ASC","idOnStore:DESC","createdAt:ASC","createdAt:DESC","sellerName:ASC","sellerName:DESC","price:ASC","price:DESC"] // kotlin.collections.List<kotlin.String> | ProductSortOption
val sellerId : kotlin.String = sellerId_example // kotlin.String | 
val storeId : kotlin.String = storeId_example // kotlin.String | 
val startDate : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val endDate : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val placementId : kotlin.String = placementId_example // kotlin.String | 
val categoryId : kotlin.String = categoryId_example // kotlin.String | 
val activated : kotlin.Boolean = true // kotlin.Boolean | 
val name : kotlin.String = name_example // kotlin.String | 
val idOnStore : kotlin.String = idOnStore_example // kotlin.String | 
val limit : java.math.BigDecimal = 8.14 // java.math.BigDecimal | 
val offset : java.math.BigDecimal = 8.14 // java.math.BigDecimal | 

launch(Dispatchers.IO) {
    val result : ProductControllerFetchMany200Response = webService.productControllerFetchMany(orderBy, sellerId, storeId, startDate, endDate, placementId, categoryId, activated, name, idOnStore, limit, offset)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderBy** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| ProductSortOption | [optional]
 **sellerId** | **kotlin.String**|  | [optional]
 **storeId** | **kotlin.String**|  | [optional]
 **startDate** | **java.time.OffsetDateTime**|  | [optional]
 **endDate** | **java.time.OffsetDateTime**|  | [optional]
 **placementId** | **kotlin.String**|  | [optional]
 **categoryId** | **kotlin.String**|  | [optional]
 **activated** | **kotlin.Boolean**|  | [optional]
 **name** | **kotlin.String**|  | [optional]
 **idOnStore** | **kotlin.String**|  | [optional]
 **limit** | **java.math.BigDecimal**|  | [optional]
 **offset** | **java.math.BigDecimal**|  | [optional]

### Return type

[**ProductControllerFetchMany200Response**](ProductControllerFetchMany200Response.md)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json




Fetch one product.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductApi::class.java)
val id : kotlin.String = id_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : FetchProductResponseDto = webService.productControllerFetchOne(id)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

[**FetchProductResponseDto**](FetchProductResponseDto.md)

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
val webService = apiClient.createWebservice(ProductApi::class.java)
val id : kotlin.String = id_example // kotlin.String | 
val updateProductDto : UpdateProductDto =  // UpdateProductDto | 

launch(Dispatchers.IO) {
    webService.productControllerUpdate(id, updateProductDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **updateProductDto** | [**UpdateProductDto**](UpdateProductDto.md)|  |

### Return type

null (empty response body)

### Authorization



### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json




Bulk upsert products.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductApi::class.java)
val upsertManyProductDto : UpsertManyProductDto =  // UpsertManyProductDto | 

launch(Dispatchers.IO) {
    val result : UpsertManyProductResponseDto = webService.productControllerUpsertMany(upsertManyProductDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **upsertManyProductDto** | [**UpsertManyProductDto**](UpsertManyProductDto.md)|  |

### Return type

[**UpsertManyProductResponseDto**](UpsertManyProductResponseDto.md)

### Authorization



### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

