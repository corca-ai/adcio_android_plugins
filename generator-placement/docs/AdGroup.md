
# AdGroup

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**title** | **kotlin.String** |  | 
**type** | [**inline**](#Type) |  | 
**placementId** | **kotlin.String** |  | 
**maxBudgetPerDay** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**totalBudgetInPeriod** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**budgetType** | [**inline**](#BudgetType) |  | 
**dailyUsedBudget** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**totalUsedBudget** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**activated** | **kotlin.Boolean** |  | 
**startsAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**endsAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**sellerId** | **kotlin.String** |  | 
**campaignId** | **kotlin.String** |  | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 


<a id="Type"></a>
## Enum: type
Name | Value
---- | -----
type | GRID


<a id="BudgetType"></a>
## Enum: budgetType
Name | Value
---- | -----
budgetType | DAILY_BUDGET, TOTAL_BUDGET_IN_PERIOD, MAX_BUDGET_PER_DAY



