package ai.corca.adcio_android_plugins.agent.ui

import ai.corca.adcio_agent_compose.agent.callAdcioAgent
import ai.corca.adcio_agent_compose.provider.ComposeWebViewManager
import ai.corca.adcio_agent_compose.provider.composeProductId
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class ComposeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") { MainScreen(navController = navController) }
                composable("agent") { agentScreen(navController = navController) }
            }
        }
    }

    @Composable
    fun MainScreen(navController: NavController) {
        val composeWebViewManager = ComposeWebViewManager()
        composeWebViewManager.setDelayedString(composeProductId)
        val getComposeProductId = composeWebViewManager.getDelayedString()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                navController.navigate("agent")
                composeWebViewManager.emptyProductId()
            }) {
                Text(text = "Go to WebView")
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = getComposeProductId)
        }
    }

    @Composable
    fun agentScreen(
        navController: NavController
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
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
                modifier = Modifier.fillMaxSize(),
                clientId = "30cb6fd0-17a5-4c56-b144-fef67de81bef",
                baseUrl = "https://agent-dev.adcio.ai",
                navController = navController
            )
        }
    }
}
