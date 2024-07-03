
# BannerSuggestionRequestDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sessionId** | **kotlin.String** | The session starts when the customer visits the store. It persists until the customer closes the tab, browser or app. | 
**deviceId** | **kotlin.String** | The device identifier should be unique for each device. A customer can have multiple devices. | 
**placementId** | **kotlin.String** | Identifier for the placement which the suggestion will be placed. | 
**customerId** | **kotlin.String** | The customer identifier which is generated and managed by the store. The store should configure &#x60;frontApi&#x60; parameter of ADCIO SDK so that the &#x60;customerId&#x60; can be sent to ADCIO API. |  [optional]
**placementPositionX** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | The X coordinate of the placement in pixel. |  [optional]
**placementPositionY** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | The Y coordinate of the placement in pixel. |  [optional]
**fromAgent** | **kotlin.Boolean** | Whether the request is from the ADCIO agent or not. Default value is &#x60;false&#x60;. |  [optional]
**birthYear** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | The birth year of the customer. |  [optional]
**gender** | [**inline**](#Gender) | The gender of the customer. |  [optional]


<a id="Gender"></a>
## Enum: gender
Name | Value
---- | -----
gender | male, female



