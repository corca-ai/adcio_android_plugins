# PageApi

All URIs are relative to *https://api.adcio.ai*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pageControllerFetchActivePlacements**](PageApi.md#pageControllerFetchActivePlacements) | **GET** pages/{name}/placements | 





Fetch active placements of the page.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.adcio_placement.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PageApi::class.java)
val name : kotlin.String = name_example // kotlin.String | 
val clientId : kotlin.String = ab2da386-a884-47b1-92c9-2f38fd3d23c6 // kotlin.String | The client ID of the placement owner.

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<FetchActivePlacementsResponseDto> = webService.pageControllerFetchActivePlacements(name, clientId)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **kotlin.String**|  |
 **clientId** | **kotlin.String**| The client ID of the placement owner. |

### Return type

[**kotlin.collections.List&lt;FetchActivePlacementsResponseDto&gt;**](FetchActivePlacementsResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

