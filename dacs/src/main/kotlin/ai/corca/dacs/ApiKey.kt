package ai.corca.dacs

import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.util.*

val openaiApiKey: String = loadApiKey()

private fun loadApiKey(): String {
    val properties = Properties()
    val localPropertiesFile = File("local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { properties.load(it) }
    }
    return properties.getProperty("OPENAI_API_KEY")
        ?: throw IllegalStateException("OPENAI_API_KEY not found in local.properties")
}