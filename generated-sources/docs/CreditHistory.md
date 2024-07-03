
# CreditHistory

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**store** | [**Client**](Client.md) |  | 
**storeId** | **kotlin.String** |  | 
**seller** | [**Client**](Client.md) |  | 
**sellerId** | **kotlin.String** |  | 
**creditType** | [**kotlin.Any**](.md) |  | 
**adjustmentType** | [**inline**](#AdjustmentType) |  | 
**amount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**transaction** | [**Transaction**](Transaction.md) |  | 
**creditDecreaseRequest** | [**CreditDecreaseRequest**](CreditDecreaseRequest.md) |  | 


<a id="AdjustmentType"></a>
## Enum: adjustmentType
Name | Value
---- | -----
adjustmentType | INCREASE, DECREASE



