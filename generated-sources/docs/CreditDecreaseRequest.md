
# CreditDecreaseRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**store** | [**Client**](Client.md) |  | 
**storeId** | **kotlin.String** |  | 
**seller** | [**Client**](Client.md) |  | 
**sellerId** | **kotlin.String** |  | 
**amount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**requestedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**reason** | **kotlin.String** |  | 
**rejectionReason** | **kotlin.String** |  | 
**status** | [**inline**](#Status) |  | 
**processedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**creditHistory** | [**CreditHistory**](CreditHistory.md) |  | 


<a id="Status"></a>
## Enum: status
Name | Value
---- | -----
status | PENDING, APPROVED, REJECTED



