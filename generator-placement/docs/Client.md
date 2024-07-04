
# Client

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**name** | **kotlin.String** |  | 
**currency** | [**inline**](#Currency) |  | 
**timezone** | [**inline**](#Timezone) |  | 
**credit** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**paidCredit** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**freeCredit** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**type** | [**inline**](#Type) |  | 
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**paymentCardId** | **kotlin.String** |  | 
**storeId** | **kotlin.String** |  | 
**businessLicenseId** | **kotlin.String** |  | 
**isSeller** | **kotlin.Boolean** |  | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 


<a id="Currency"></a>
## Enum: currency
Name | Value
---- | -----
currency | KRW, USD, VND


<a id="Timezone"></a>
## Enum: timezone
Name | Value
---- | -----
timezone | KST, ICT, EST, CST, MST, PST, AKST, HST


<a id="Type"></a>
## Enum: type
Name | Value
---- | -----
type | PLATFORM_AND_SELLER, OWN_WEBSITE_AND_SELLER, PLATFORM, OWN_WEBSITE, SELLER, ADMIN



