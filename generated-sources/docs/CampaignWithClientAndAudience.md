
# CampaignWithClientAndAudience

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**client** | [**Client**](Client.md) |  | 
**audience** | [**Audience**](Audience.md) |  | 
**id** | **kotlin.String** |  | 
**title** | **kotlin.String** |  | 
**placementId** | **kotlin.String** |  | 
**maxBudgetPerDay** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**totalBudgetInPeriod** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**budgetType** | [**inline**](#BudgetType) |  | 
**usedBudget** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**activated** | **kotlin.Boolean** |  | 
**startsAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**endsAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**clientId** | **kotlin.String** |  | 
**clickLookbackWindowDays** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**impressionLookbackWindowDays** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  | 


<a id="BudgetType"></a>
## Enum: budgetType
Name | Value
---- | -----
budgetType | DAILY_BUDGET, TOTAL_BUDGET_IN_PERIOD, MAX_BUDGET_PER_DAY



