
# FetchManyPlacementsResponseDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**placementFormatRatio** | **kotlin.String** |  | 
**page** | [**FetchPageClientDto**](FetchPageClientDto.md) |  | 
**products** | [**kotlin.collections.List&lt;Product&gt;**](Product.md) |  | 
**banners** | [**kotlin.collections.List&lt;Banner&gt;**](Banner.md) |  | 
**id** | **kotlin.String** |  | 
**title** | **kotlin.String** |  | 
**type** | [**inline**](#Type) |  | 
**suggestionType** | [**inline**](#SuggestionType) |  | 
**bannerPlacementType** | [**inline**](#BannerPlacementType) |  | 
**supportEnvironment** | [**inline**](#SupportEnvironment) |  | 
**developEnvironment** | [**inline**](#DevelopEnvironment) |  | 
**displayCount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**minDisplayCount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**maxDisplayCount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**activated** | **kotlin.Boolean** |  | 
**pageName** | **kotlin.String** |  | 
**clientId** | **kotlin.String** |  | 
**injector** | [**Injector**](Injector.md) |  | 
**screenShot** | **kotlin.String** |  | 
**displayFormatWidth** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**displayFormatHeight** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**&#x60;property&#x60;** | [**inline**](#&#x60;Property&#x60;) |  | 
**displayPositions** | [**kotlin.collections.List&lt;java.math.BigDecimal&gt;**](java.math.BigDecimal.md) |  | 
**tableSize** | [**kotlin.collections.List&lt;java.math.BigDecimal&gt;**](java.math.BigDecimal.md) |  | 
**widgetValueId** | **kotlin.String** |  | 
**productDetailDataColumns** | **kotlin.collections.List&lt;kotlin.String&gt;** |  | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 


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


<a id="`Property`"></a>
## Enum: property
Name | Value
---- | -----
&#x60;property&#x60; | NEW, HOT, PERSONAL, SAME_GOODS, DIFF_GOODS



