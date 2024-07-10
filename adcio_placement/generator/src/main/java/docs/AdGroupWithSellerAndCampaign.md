
# AdGroupWithSellerAndCampaign

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**seller** | [**Client**](Client.md) |  | 
**budgetType** | [**inline**](#BudgetType) |  | 
**totalUsedBudget** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**placementId** | **kotlin.String** |  | 
**campaignId** | **kotlin.String** |  | 
**title** | **kotlin.String** |  | 
**type** | [**inline**](#Type) |  | 
**totalBudgetInPeriod** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**targets** | [**kotlin.collections.List&lt;AdGroupTargetKeyValueResponse&gt;**](AdGroupTargetKeyValueResponse.md) |  | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**sellerId** | **kotlin.String** |  | 
**maxBudgetPerDay** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**dailyUsedBudget** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**campaign** | [**Campaign**](Campaign.md) |  | 
**startsAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**id** | **kotlin.String** |  | 
**endsAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**activated** | **kotlin.Boolean** |  | 
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 


<a id="BudgetType"></a>
## Enum: budgetType
Name | Value
---- | -----
budgetType | DAILY_BUDGET, TOTAL_BUDGET_IN_PERIOD, MAX_BUDGET_PER_DAY


<a id="Type"></a>
## Enum: type
Name | Value
---- | -----
type | GRID



