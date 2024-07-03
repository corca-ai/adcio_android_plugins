
# FetchBannerResponseDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**clientId** | **kotlin.String** |  | 
**campaigns** | [**kotlin.collections.List&lt;Campaign&gt;**](Campaign.md) |  | 
**type** | [**inline**](#Type) |  | 
**url** | **kotlin.String** |  | 
**name** | **kotlin.String** |  | 
**&#x60;data&#x60;** | [**kotlin.Any**](.md) |  | 
**categoryId** | **kotlin.String** |  | 
**productId** | **kotlin.String** |  | 
**activated** | **kotlin.Boolean** |  | 
**deepLink** | **kotlin.String** |  | 
**appRoute** | **kotlin.String** |  | 
**startsAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**endsAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**category** | [**CategoryWithPath**](CategoryWithPath.md) |  | 
**product** | [**Product**](Product.md) |  | 
**placements** | [**kotlin.collections.List&lt;Placement&gt;**](Placement.md) |  | 
**creatives** | [**kotlin.collections.List&lt;Creative&gt;**](Creative.md) |  | 


<a id="Type"></a>
## Enum: type
Name | Value
---- | -----
type | video, image



