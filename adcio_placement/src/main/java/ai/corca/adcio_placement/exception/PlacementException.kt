package ai.corca.adcio_placement.exception

private const val NOT_INITIALIZED_EXCEPTION_MESSAGE = "Not initialized. (Call the init function.)"
internal const val UNKNOWN_EXCEPTION_MESSAGE = "Unknown error has occurred."

class NotInitializedException : RuntimeException() {
    override val message: String
        get() = NOT_INITIALIZED_EXCEPTION_MESSAGE
}
