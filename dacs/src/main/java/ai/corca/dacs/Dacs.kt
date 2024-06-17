package ai.corca.dacs

import android.util.Log
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import week1.domain.key.openAiKey

class Dacs {
    @Suppress("UNREACHABLE_CODE")
    suspend fun greet(name: String): String {
        val openAI = OpenAI(
            token = openAiKey
        )

        val chatMessages = mutableListOf(
            ChatMessage(
                role = ChatRole.System,
                content = "첫번쨰 링크와 두번째 링크의 코드가 있는데 이 코드들의 차이가 뭐야??"
            ),
            ChatMessage(
                role = ChatRole.User,
                content = "https://github.com/corca-ai/adcio_android_plugins/blob/main/adcio_placement/src/main/java/ai/corca/adcio_placement/feature/AdcioPlacement.kt, https://github.com/corca-ai/adcio_android_plugins/blob/develop/adcio_placement/src/main/java/ai/corca/adcio_placement/feature/AdcioPlacement.kt"
            )
        )

        val response = openAI.chatCompletion(
            request = ChatCompletionRequest(
                model = ModelId("gpt-4"),
                messages = chatMessages
            )
        )

        Log.d("timetogotobed", response.toString())

        return response.toString()
    }
}