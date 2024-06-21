package ai.corca.dacs

import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.time.Duration.Companion.seconds

class CreateDacs {

    private fun prepareInput(existingDoc: String, sdkDiff: String): String {
        return """
            existing Docs:
            $existingDoc
            
            SDK Diff: 
            $sdkDiff
            
            Please update the documentation according to the provided SDK diff. 
            Note that lines starting with '+' indicate additions and lines starting with '-' indicate deletions.
            
            Since all parts of Docs are mostly contained in ADCIOAnalytics and ADCIOPlacement, changes in these parts need to be detected and reflected.
            Simply replace the content in the original article and return it so that it can be updated directly in PROD without any further explanation.
        """.trimIndent()
    }

    private suspend fun cleanDiff(apiKey: String, diff: String): String {
        val openAI = OpenAI(
            apiKey,
            timeout = Timeout(socket = 60.seconds),
        )

        val messages = listOf(
            ChatMessage(
                role = ChatRole.System,
                content = "Below is my diff of changes, please remove all of them except " +
                        "the adcio_placement/src/main/java/ai/corca/adcio_placement/feature/AdcioPlacement.kt diff and the adcio_analytics/src/main/java/ai/corca/adcio_analytics/feature/AdcioAnalytics.kt diff."
            ),
            ChatMessage(
                role = ChatRole.User,
                content = diff
            )
        )

        val response = openAI.chatCompletion(
            request = ChatCompletionRequest(
                model = ModelId("gpt-4"),
                messages = messages
            )
        )

        print(response.choices[0].message.content!!.trim().toString())

        return response.choices[0].message.content!!.trim()
    }

    private suspend fun getUpdatedDocument(apiKey: String, input: String): String {
        val openAI = OpenAI(
            apiKey,
            timeout = Timeout(socket = 60.seconds),
        )

        val messages = listOf(
            ChatMessage(
                role = ChatRole.System,
                content = "You are a helpful assistant who updates documentation based on SDK changes." +
                        "Detect the diff, apply the changes to the existing docs, and return the new full docs."
            ),
            ChatMessage(
                role = ChatRole.User,
                content = input
            )
        )

        val response = openAI.chatCompletion(
            request = ChatCompletionRequest(
                model = ModelId("gpt-3.5-turbo"),
                messages = messages
            )
        )

        return response.choices[0].message.content!!.trim()
    }

    private fun readReadmeFile(filePath: String): String {
        val file = File(filePath)
        if (!file.exists()) {
            throw IllegalStateException("README.md not found at $filePath")
        }
        return file.readText()
    }

    suspend fun greet(diff: String): String {
        val apiKey = System.getenv("OPENAI_API_KEY")
            ?: throw IllegalStateException("OPENAI_API_KEY not found in environment variables")

        val readmeFilePath = "dacs/README.md"
        val existingDoc = readReadmeFile(readmeFilePath)

        return withContext(Dispatchers.IO) {
            val newDiff = cleanDiff(apiKey, diff)
            val input = prepareInput(existingDoc, newDiff.trimIndent())
            val updatedDoc = getUpdatedDocument(apiKey, input)

            print("업데이트된 문서: $updatedDoc")

            "업데이트된 문서: $updatedDoc"
        }
    }
}