import java.net.HttpURLConnection
import java.net.URL
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.file.Files
import java.nio.file.Paths

fun fetchContent(fileUrl: String): String {
    val url = URL(fileUrl)
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    val response = StringBuilder()
    BufferedReader(InputStreamReader(connection.inputStream)).use { reader ->
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            response.append(line).append("\n")
        }
    }
    return response.toString()
}

fun updateReadme(readmePath: String, oldInterfaceContent: String, newInterfaceContent: String) {
    val path = Paths.get(readmePath)
    val existingContent = Files.readString(path)
    val updatedContent = existingContent.replace(oldInterfaceContent, newInterfaceContent)
    Files.writeString(path, updatedContent)
}

fun main() {
    val readmePath = System.getenv("README_PATH")
    val oldInterfaceUrl = System.getenv("OLD_INTERFACE_URL")
    val newInterfaceUrl = System.getenv("NEW_INTERFACE_URL")

    val oldInterfaceContent = fetchContent(oldInterfaceUrl)
    val newInterfaceContent = fetchContent(newInterfaceUrl)

    updateReadme(readmePath, oldInterfaceContent, newInterfaceContent)
}