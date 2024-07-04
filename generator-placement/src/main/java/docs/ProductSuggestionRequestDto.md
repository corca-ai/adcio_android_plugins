
# ProductSuggestionRequestDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**clientId** | **kotlin.String** | Identifier for the request client. | 
**placementId** | **kotlin.String** | Identifier for the placement which the suggestion will be placed. | 
**sessionId** | **kotlin.String** | The session starts when the customer visits the store. It persists until the customer closes the tab, browser or app. | 
**deviceId** | **kotlin.String** | The device identifier should be unique for each device. A customer can have multiple devices. | 
**excludingProductIds** | **kotlin.collections.List&lt;kotlin.String&gt;** | Product IDs(on store) that should NOT be included in the suggestion. |  [optional]
**userAgent** | **kotlin.String** |  |  [optional]
**filters** | **kotlin.collections.List&lt;kotlin.collections.Map&lt;kotlin.String, ProductFilterOperationDto&gt;&gt;** | Product filters for filtering adsets. |  [optional]
**targets** | [**kotlin.collections.List&lt;SuggestionRequestTarget&gt;**](SuggestionRequestTarget.md) |  |  [optional]
**placementPositionY** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | The Y coordinate of the placement in pixel. |  [optional]
**placementPositionX** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | The X coordinate of the placement in pixel. |  [optional]
**baselineProductIds** | **kotlin.collections.List&lt;kotlin.String&gt;** | Product IDs(on store) that support the fixed baseline suggestion. |  [optional]
**customerId** | **kotlin.String** | The customer identifier which is generated and managed by the store. The store should configure &#x60;frontApi&#x60; parameter of ADCIO SDK so that the &#x60;customerId&#x60; can be sent to ADCIO API. |  [optional]
**fromAgent** | **kotlin.Boolean** | Whether the request is from the ADCIO agent or not. Default value is &#x60;false&#x60;. |  [optional]
**sdkVersion** | **kotlin.String** | The version of the SDK |  [optional]
**categoryId** | **kotlin.String** | The category id(on store) for filtering adsets. |  [optional]



