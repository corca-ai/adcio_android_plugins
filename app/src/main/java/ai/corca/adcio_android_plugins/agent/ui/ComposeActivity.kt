package ai.corca.adcio_android_plugins.agent.ui

import ai.corca.adcio_agent_compose.agent.callAdcioAgent
import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            agentScreen(
                modifier = Modifier
                    .fillMaxSize(),
                this
            )
        }
    }

    @Composable
    fun agentScreen(
        modifier: Modifier,
        context: Context
    ) {
        Column(
            modifier = modifier
        ) {
            Row(
                modifier = Modifier
                    .background(color = Color.Blue)
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    fontSize = 18.sp,
                    text = "adcio_agent example",
                    color = Color.White
                )
            }
            callAdcioAgent(
                clientId = "30cb6fd0-17a5-4c56-b144-fef67de81bef",
                baseUrl = "https://agent-dev.adcio.ai",
                this@ComposeActivity
            )
        }
    }
}
