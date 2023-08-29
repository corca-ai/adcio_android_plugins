package ai.corca.adcio_placement.mapper

import ai.corca.adcio_placement.model.Placement
import ai.corca.adcio_placement.model.Property
import ai.corca.adcio_placement.model.SuggestionType
import ai.corca.adcio_placement.model.Type
import ai.corca.adcio_placement.network.data.PlacementData
import ai.corca.adcio_placement.network.data.PropertyData
import ai.corca.adcio_placement.network.data.SuggestionTypeData
import ai.corca.adcio_placement.network.data.TypeData

internal fun Placement.toPlacementData(): PlacementData = PlacementData(
    id = this.id,
    title = this.title,
    type = this.type.toTypeData(),
    suggestionType = this.suggestionType.toSuggestionTypeData(),
    displayCount = this.displayCount,
    activated = this.activated,
    clientId = this.clientId,
    pageUrl = this.pageUrl,
    screenShot = this.screenShot,
    displayFormatWidth = this.displayFormatWidth,
    displayFormatHeight = this.displayFormatHeight,
    placementProperty = this.placementProperty.toPropertyData(),
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
    deletedAt = this.deletedAt,
)

internal fun PlacementData.toPlacement(): Placement = Placement(
    id = this.id,
    title = this.title,
    type = this.type.toType(),
    suggestionType = this.suggestionType.toSuggestionType(),
    displayCount = this.displayCount,
    activated = this.activated,
    clientId = this.clientId,
    pageUrl = this.pageUrl,
    screenShot = this.screenShot,
    displayFormatWidth = this.displayFormatWidth,
    displayFormatHeight = this.displayFormatHeight,
    placementProperty = this.placementProperty.toProperty(),
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
    deletedAt = this.deletedAt,
)

internal fun PropertyData.toProperty(): Property = when (this.name) {
    Property.NEW.name -> Property.NEW
    Property.HOT.name -> Property.HOT
    Property.PERSONAL.name -> Property.PERSONAL
    Property.SAME_GOODS.name -> Property.SAME_GOODS
    Property.DIFF_GOODS.name -> Property.DIFF_GOODS
    else -> Property.NEW
}

internal fun TypeData.toType(): Type = when (this.name) {
    Type.GRID.name -> Type.GRID
    Type.BANNER.name -> Type.BANNER
    else -> Type.GRID
}

internal fun SuggestionTypeData.toSuggestionType(): SuggestionType = when (this.name) {
    SuggestionType.RECOMMEND.name -> SuggestionType.RECOMMEND
    SuggestionType.ADVERTISE.name -> SuggestionType.ADVERTISE
    else -> SuggestionType.RECOMMEND
}

internal fun Property.toPropertyData(): PropertyData = when (this.name) {
    PropertyData.NEW.name -> PropertyData.NEW
    PropertyData.HOT.name -> PropertyData.HOT
    PropertyData.PERSONAL.name -> PropertyData.PERSONAL
    PropertyData.SAME_GOODS.name -> PropertyData.SAME_GOODS
    PropertyData.DIFF_GOODS.name -> PropertyData.DIFF_GOODS
    else -> PropertyData.NEW
}

internal fun Type.toTypeData(): TypeData = when (this.name) {
    TypeData.GRID.name -> TypeData.GRID
    TypeData.BANNER.name -> TypeData.BANNER
    else -> TypeData.GRID
}

internal fun SuggestionType.toSuggestionTypeData(): SuggestionTypeData = when (this.name) {
    SuggestionTypeData.RECOMMEND.name -> SuggestionTypeData.RECOMMEND
    SuggestionTypeData.ADVERTISE.name -> SuggestionTypeData.ADVERTISE
    else -> SuggestionTypeData.RECOMMEND
}
