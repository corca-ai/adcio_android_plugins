
# Transaction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**impUid** | **kotlin.String** |  | 
**impVBank** | [**IamportPaymentVBank**](IamportPaymentVBank.md) |  | 
**paymentCard** | [**TransactionPaymentCard**](TransactionPaymentCard.md) |  | 
**clientId** | **kotlin.String** |  | 
**amount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**currency** | [**inline**](#Currency) |  | 
**paymentMethod** | [**inline**](#PaymentMethod) |  | 
**status** | [**inline**](#Status) |  | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**paidAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**category** | [**inline**](#Category) |  | 
**type** | [**inline**](#Type) |  | 
**failedReason** | [**inline**](#FailedReason) |  | 
**creditHistory** | [**CreditHistory**](CreditHistory.md) |  | 


<a id="Currency"></a>
## Enum: currency
Name | Value
---- | -----
currency | KRW, USD, VND


<a id="PaymentMethod"></a>
## Enum: paymentMethod
Name | Value
---- | -----
paymentMethod | Card, DirectBank, VBank, HPP


<a id="Status"></a>
## Enum: status
Name | Value
---- | -----
status | Pending, Ready, Completed, Unauthorized, Failed, Closed, Cancelled


<a id="Category"></a>
## Enum: category
Name | Value
---- | -----
category | AUTO_CHARGE, SUBSCRIPTION


<a id="Type"></a>
## Enum: type
Name | Value
---- | -----
type | PAY, REFUND


<a id="FailedReason"></a>
## Enum: failedReason
Name | Value
---- | -----
failedReason | CLOSED_CARD, BALANCE_INSUFFICIENT, ETC



