package ai.corca.adcio_analytics.exception

private const val NOT_INITIALIZED_EXCEPTION_MESSAGE = "Not initialized. (Call the init function.)"
private const val EMPTY_ENV_EXCEPTION_MESSAGE = "No environment variables have been entered."
private const val INVALID_URL_FORMAT_MESSAGE = "Invalid URL format."
internal const val UNKNOWN_EXCEPTION_MESSAGE = "Unknown error has occurred."

class NotInitializedException : RuntimeException() {
    override val message: String
        get() = NOT_INITIALIZED_EXCEPTION_MESSAGE
}

class EmptyEnvFileException : RuntimeException() {
    override val message: String
        get() = EMPTY_ENV_EXCEPTION_MESSAGE
}

class InvalidUrlFormatException : RuntimeException() {
    override val message: String
        get() = INVALID_URL_FORMAT_MESSAGE
}
