
# ProductSuggestionRequestDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sessionId** | **kotlin.String** | The session starts when the customer visits the store. It persists until the customer closes the tab, browser or app. | 
**deviceId** | **kotlin.String** | The device identifier should be unique for each device. A customer can have multiple devices. | 
**placementId** | **kotlin.String** | Identifier for the placement which the suggestion will be placed. | 
**clientId** | **kotlin.String** | Identifier for the request client. | 
**customerId** | **kotlin.String** | The customer identifier which is generated and managed by the store. The store should configure &#x60;frontApi&#x60; parameter of ADCIO SDK so that the &#x60;customerId&#x60; can be sent to ADCIO API. |  [optional]
**sdkVersion** | **kotlin.String** | The version of the SDK |  [optional]
**placementPositionX** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | The X coordinate of the placement in pixel. |  [optional]
**placementPositionY** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | The Y coordinate of the placement in pixel. |  [optional]
**fromAgent** | **kotlin.Boolean** | Whether the request is from the ADCIO agent or not. Default value is &#x60;false&#x60;. |  [optional]
**excludingProductIds** | **kotlin.collections.List&lt;kotlin.String&gt;** | Product IDs(on store) that should NOT be included in the suggestion. |  [optional]
**baselineProductIds** | **kotlin.collections.List&lt;kotlin.String&gt;** | Product IDs(on store) that support the fixed baseline suggestion. |  [optional]
**categoryId** | **kotlin.String** | The category id(on store) for filtering adsets. |  [optional]
**filters** | **kotlin.collections.List&lt;kotlin.collections.Map&lt;kotlin.String, ProductFilterOperationDto&gt;&gt;** | Product filters for filtering adsets. |  [optional]
**targets** | [**kotlin.collections.List&lt;SuggestionRequestTarget&gt;**](SuggestionRequestTarget.md) |  |  [optional]
**userAgent** | **kotlin.String** |  |  [optional]



