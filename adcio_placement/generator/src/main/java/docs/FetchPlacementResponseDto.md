
# FetchPlacementResponseDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**displayFormatHeight** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**supportEnvironment** | [**inline**](#SupportEnvironment) |  | 
**developEnvironment** | [**inline**](#DevelopEnvironment) |  | 
**title** | **kotlin.String** |  | 
**type** | [**inline**](#Type) |  | 
**pageName** | **kotlin.String** |  | 
**suggestionType** | [**inline**](#SuggestionType) |  | 
**productDetailDataColumns** | **kotlin.collections.List&lt;kotlin.String&gt;** |  | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**displayFormatWidth** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**bannerPlacementType** | [**inline**](#BannerPlacementType) |  | 
**displayCount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**maxDisplayCount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**tableSize** | [**kotlin.collections.List&lt;java.math.BigDecimal&gt;**](java.math.BigDecimal.md) |  | 
**screenShot** | **kotlin.String** |  | 
**&#x60;property&#x60;** | [**inline**](#&#x60;Property&#x60;) |  | 
**id** | **kotlin.String** |  | 
**injector** | [**Injector**](Injector.md) |  | 
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**clientId** | **kotlin.String** |  | 
**placementFormatRatio** | **kotlin.String** |  | 
**minDisplayCount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**displayPositions** | [**kotlin.collections.List&lt;java.math.BigDecimal&gt;**](java.math.BigDecimal.md) |  | 
**page** | [**FetchPageClientDto**](FetchPageClientDto.md) |  | 
**widgetValueId** | **kotlin.String** |  | 
**activated** | **kotlin.Boolean** |  | 
**products** | [**kotlin.collections.List&lt;ProductWithSeller&gt;**](ProductWithSeller.md) |  |  [optional]
**banners** | [**kotlin.collections.List&lt;BannerWithCreative&gt;**](BannerWithCreative.md) |  |  [optional]
**adGroups** | [**kotlin.collections.List&lt;AdGroupWithSellerAndCampaign&gt;**](AdGroupWithSellerAndCampaign.md) |  |  [optional]


<a id="SupportEnvironment"></a>
## Enum: supportEnvironment
Name | Value
---- | -----
supportEnvironment | WEB, WEB_MOBILE, APP


<a id="DevelopEnvironment"></a>
## Enum: developEnvironment
Name | Value
---- | -----
developEnvironment | WIDGET, SELF_DEVELOPED, CODE_INJECTOR


<a id="Type"></a>
## Enum: type
Name | Value
---- | -----
type | GRID, BANNER


<a id="SuggestionType"></a>
## Enum: suggestionType
Name | Value
---- | -----
suggestionType | RECOMMEND, ADVERTISE


<a id="BannerPlacementType"></a>
## Enum: bannerPlacementType
Name | Value
---- | -----
bannerPlacementType | STATIC, SLIDE


<a id="`Property`"></a>
## Enum: property
Name | Value
---- | -----
&#x60;property&#x60; | NEW, HOT, PERSONAL, SAME_GOODS, DIFF_GOODS



