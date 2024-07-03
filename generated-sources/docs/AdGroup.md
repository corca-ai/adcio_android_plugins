
# AdGroup

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**title** | **kotlin.String** |  | 
**placement** | [**Placement**](Placement.md) |  | 
**placementId** | **kotlin.String** |  | 
**maxBudgetPerDay** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**totalBudgetInPeriod** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**budgetType** | [**inline**](#BudgetType) |  | 
**usedBudget** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**activated** | **kotlin.Boolean** |  | 
**products** | [**kotlin.collections.List&lt;Product&gt;**](Product.md) |  | 
**banners** | [**kotlin.collections.List&lt;Banner&gt;**](Banner.md) |  | 
**startsAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**endsAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**campaign** | [**Campaign**](Campaign.md) |  | 
**campaignId** | **kotlin.String** |  | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 


<a id="BudgetType"></a>
## Enum: budgetType
Name | Value
---- | -----
budgetType | DAILY_BUDGET, TOTAL_BUDGET_IN_PERIOD, MAX_BUDGET_PER_DAY



