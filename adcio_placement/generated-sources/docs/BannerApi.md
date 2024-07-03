# BannerApi

All URIs are relative to *https://api.adcio.ai*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bannerControllerCreate**](BannerApi.md#bannerControllerCreate) | **POST** banners | 
[**bannerControllerDelete**](BannerApi.md#bannerControllerDelete) | **DELETE** banners/{id} | 
[**bannerControllerFetchMany**](BannerApi.md#bannerControllerFetchMany) | **GET** banners | 
[**bannerControllerFetchOne**](BannerApi.md#bannerControllerFetchOne) | **GET** banners/{id} | 
[**bannerControllerUpdate**](BannerApi.md#bannerControllerUpdate) | **PUT** banners/{id} | 





### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(BannerApi::class.java)
val createBannerDto : CreateBannerDto =  // CreateBannerDto | 

launch(Dispatchers.IO) {
    val result : Banner = webService.bannerControllerCreate(createBannerDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createBannerDto** | [**CreateBannerDto**](CreateBannerDto.md)|  |

### Return type

[**Banner**](Banner.md)

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
val webService = apiClient.createWebservice(BannerApi::class.java)
val id : kotlin.String = id_example // kotlin.String | 

launch(Dispatchers.IO) {
    webService.bannerControllerDelete(id)
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
val webService = apiClient.createWebservice(BannerApi::class.java)
val orderBy : kotlin.collections.List<kotlin.String> = ["name:ASC","name:DESC","activated:ASC","activated:DESC","startsAt:ASC","startsAt:DESC","createdAt:ASC","createdAt:DESC"] // kotlin.collections.List<kotlin.String> | BannerSortOption
val select : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val activated : kotlin.Boolean = true // kotlin.Boolean | 
val name : kotlin.String = name_example // kotlin.String | 
val placementIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val type : kotlin.String = type_example // kotlin.String | 
val startsAt : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val endsAt : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val limit : java.math.BigDecimal = 8.14 // java.math.BigDecimal | 
val offset : java.math.BigDecimal = 8.14 // java.math.BigDecimal | 

launch(Dispatchers.IO) {
    val result : BannerControllerFetchMany200Response = webService.bannerControllerFetchMany(orderBy, select, activated, name, placementIds, type, startsAt, endsAt, limit, offset)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderBy** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| BannerSortOption | [optional]
 **select** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: id, name, imageUrl, url, data, activated, startsAt, endsAt, createdAt]
 **activated** | **kotlin.Boolean**|  | [optional]
 **name** | **kotlin.String**|  | [optional]
 **placementIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional]
 **type** | **kotlin.String**|  | [optional] [enum: video, image]
 **startsAt** | **java.time.OffsetDateTime**|  | [optional]
 **endsAt** | **java.time.OffsetDateTime**|  | [optional]
 **limit** | **java.math.BigDecimal**|  | [optional]
 **offset** | **java.math.BigDecimal**|  | [optional]

### Return type

[**BannerControllerFetchMany200Response**](BannerControllerFetchMany200Response.md)

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
val webService = apiClient.createWebservice(BannerApi::class.java)
val id : kotlin.String = id_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : FetchBannerResponseDto = webService.bannerControllerFetchOne(id)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

[**FetchBannerResponseDto**](FetchBannerResponseDto.md)

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
val webService = apiClient.createWebservice(BannerApi::class.java)
val id : kotlin.String = id_example // kotlin.String | 
val updateBannerDto : UpdateBannerDto =  // UpdateBannerDto | 

launch(Dispatchers.IO) {
    val result : Banner = webService.bannerControllerUpdate(id, updateBannerDto)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **updateBannerDto** | [**UpdateBannerDto**](UpdateBannerDto.md)|  |

### Return type

[**Banner**](Banner.md)

### Authorization



### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

