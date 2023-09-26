#  adcio_agent_compose
[![Analytics mavencentral badge](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_agent_compose.svg)](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_agent_compose) 

A Adcio Plugin chatbot based on LLM(GPT) that suggests personalized products through conversations

To learn more about ADCIO, please visit the [ADCIO website](https://www.adcio.ai/)
</br>

## Getting Started
To get started with ADCIO account, please register [ADCIO account](https://app.adcio.ai/en/)
</br>

## Usage
You should call `AdcioAgent` the space where Agent will be placed
```kotlin
import ai.corca.adcio_agent_compose.agent.AdcioAgent

@Composable
fun agentScreen() {
  Column(
    modifier = Modifier.fillMaxSize()
  ) {
    ...
    AdcioAgent(
        modifier = Modifier.fillMaxSize(),
        clientId = "YOUR_CLIENT_ID"
    )
  }
}
```

To learn more about usage of plugin, please visit the [AdcioAgent Usage documentation.](https://docs.adcio.ai/en/sdk/agent/android)
</br>

## Issues and feedback
If the plugin has issues, bugs, feedback, Please contact <dev@corca.ai>.
