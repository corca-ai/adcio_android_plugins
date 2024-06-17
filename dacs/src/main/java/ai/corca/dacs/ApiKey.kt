package week1.domain.key

import java.io.FileNotFoundException
import java.util.*

val openAiKey: String = loadApiKey("OPENAI_API_KEY")

fun loadApiKey(key: String): String {
    val properties = Properties()
    val inputStream = Thread.currentThread().contextClassLoader?.getResourceAsStream("local.properties")
        ?: throw FileNotFoundException("Property file 'local.properties' not found in the classpath")
    properties.load(inputStream)
    return properties.getProperty(key) ?: throw IllegalArgumentException("API Key not found")
}
