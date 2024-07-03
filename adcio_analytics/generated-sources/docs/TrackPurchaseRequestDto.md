
# TrackPurchaseRequestDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**storeId** | **kotlin.String** | ADCIO Client ID of the store. | 
**sessionId** | **kotlin.String** | The session starts when the customer visits the store. It persists until the customer closes the tab, browser or app. | 
**deviceId** | **kotlin.String** | The device identifier should be unique for each device. A customer can have multiple devices. | 
**orderId** | **kotlin.String** | Unique identifier of the order to prevent duplicate purchase tracking. | 
**amount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | The paid amount. It is used for calculating the ROAS. | 
**customerId** | **kotlin.String** | The customer identifier which is generated and managed by the store. The store should configure &#x60;frontApi&#x60; parameter of ADCIO SDK so that the &#x60;customerId&#x60; can be sent to ADCIO API. |  [optional]
**sdkVersion** | **kotlin.String** | The version of the SDK |  [optional]
**requestId** | **kotlin.String** | Identifier for the suggestion request |  [optional]
**productIdOnStore** | **kotlin.String** | Product ID (on store). |  [optional]
**adsetId** | **kotlin.String** | Product ID / Banner ID |  [optional]
**categoryIdOnStore** | **kotlin.String** | Category ID (on store). |  [optional]
**quantity** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | Quantity of the product. |  [optional]
**userAgent** | **kotlin.String** |  |  [optional]



