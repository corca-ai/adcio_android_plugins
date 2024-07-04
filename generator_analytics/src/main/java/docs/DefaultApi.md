# DefaultApi

All URIs are relative to *https://receiver.adcio.ai*

Method | HTTP request | Description
------------- | ------------- | -------------
[**appControllerGetData**](DefaultApi.md#appControllerGetData) | **GET**  | 





### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import ai.corca.analytics.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    webService.appControllerGetData()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

