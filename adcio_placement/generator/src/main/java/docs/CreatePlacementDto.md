
# CreatePlacementDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**displayFormatHeight** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**supportEnvironment** | [**inline**](#SupportEnvironment) |  | 
**developEnvironment** | [**inline**](#DevelopEnvironment) |  | 
**placementFormatRatio** | **kotlin.String** |  | 
**title** | **kotlin.String** |  | 
**type** | [**inline**](#Type) |  | 
**pageName** | **kotlin.String** |  | 
**suggestionType** | [**inline**](#SuggestionType) |  | 
**displayFormatWidth** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**minDisplayCount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**productDetailDataColumns** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional]
**bannerPlacementType** | [**inline**](#BannerPlacementType) |  |  [optional]
**maxDisplayCount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**displayCount** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**tableSize** | [**kotlin.collections.List&lt;java.math.BigDecimal&gt;**](java.math.BigDecimal.md) |  |  [optional]
**displayPositions** | [**kotlin.collections.List&lt;java.math.BigDecimal&gt;**](java.math.BigDecimal.md) |  |  [optional]
**injector** | [**PlacementInjectorDto**](PlacementInjectorDto.md) |  |  [optional]


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



