package ai.corca.adcio_android_plugins.agent.ui

import ai.corca.adcio_agent_compose.agent.AdcioAgent
import ai.corca.adcio_agent_compose.provider.AdcioAgentCompose
import ai.corca.adcio_agent_compose.provider.productId
import ai.corca.adcio_android_plugins.R
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposeActivity : AppCompatActivity() {

    @Composable
    fun agentScreen() {

        // Super simple get productId: Import productId and create a variable that remembers it.
        // if the value of productId changes, the value of “id” will also be updated
        var id by remember { productId }

        val adcioAgentCompose = AdcioAgentCompose()
        // Returns whether the current page is the first page of the agent's page.
        val isPageStart: Boolean = adcioAgentCompose.isAgentStartPage()

        val context = LocalContext.current

        if (id != "") {
            Toast.makeText(context, id, Toast.LENGTH_SHORT).show()
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AgentAppBar(
                title = "adcio_agent example",
                onClickBack = {
                    // Important: If you use the app's own AppBar to enable POP of the AppBar's WebView,
                    // You must enable the following settings: onBackPressedDispatcher.onBackPressed()
                    adcioAgentCompose.agentGoBack() // Agent move back page
                    onBackPressedDispatcher.onBackPressed() // IMPORTANT THING TO DO
                }
            )

            // Call adcio agent like this!
            // You can resize agent using modifier.
            // and set visibility of appbar in agent web page, too.
            AdcioAgent(
                modifier = Modifier.fillMaxSize(),
                clientId = "67592c00-a230-4c31-902e-82ae4fe71866",
                showAppBar = false
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            agentScreen()
        }
    }

    @Composable
    private fun AgentAppBar(
        title: String,
        onClickBack: () -> Unit,
    ) {
        Row(
            modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_back
                ),
                contentDescription = "",
                modifier = Modifier.clickable {
                    onClickBack()
                }
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                fontSize = 18.sp,
                text = title,
                color = Color.Black
            )
        }
    }
}
