package ai.corca.adcio_placement.exception

data class UnregisteredIdException(
    val code: String = "PLACEMENT_NOT_FOUND",
    val errorMessage: String = "placementID is not registered",
) : RuntimeException()

data class DisabledPlacementException(
    val code: String = "PLACEMENT_NOT_ACTIVATED",
    val errorMessage: String = "The placement is not active",
) : RuntimeException()

data class BadRequestException(
    val code: String = "BAD_REQUEST",
    val errorMessage: String = "request argument type is miss match",
) : RuntimeException()

data class UnKnownException(
    val code: String = "UNKNOWN_ERROR",
    val errorMessage: String,
) : RuntimeException()
