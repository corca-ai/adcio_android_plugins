#  adcio_agent
[![Analytics mavencentral badge](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_agent.svg)](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_agent) 

A Adcio Plugin chatbot based on LLM(GPT) that suggests personalized products through conversations

To learn more about ADCIO, please visit the [ADCIO website](https://www.adcio.ai/)
</br>

## Getting Started
To get started with ADCIO account, please register [ADCIO account](https://app.adcio.ai/en/)
</br>

## Usage
You should make `<ai.corca.adcio_agent.layout.AdcioAgentLayout>` the space where Agent will be placed

```xml
<androidx.constraintlayout.widget.ConstraintLayout>

  <ai.corca.adcio_agent.layout.AdcioAgentLayout
    android:id="@+id/adcio_agent_frame"
    ...
  />

</androidx.constraintlayout.widget.ConstraintLayout>
```

You can call the `callAdcioAgent` function of the `AdcioAgent` object to expose the Agent to the screen.
```kotlin
class XmlActivity: AppCompatActivity() {

  ...

  private val agent = AdcioAgent(
      context = this,
      clientId = "YOUR_CLIENT_ID",
      fragmentContainer = R.id.adcio_agent_frame,
  )
  
  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      agent.callAdcioAgent()
  }
}
```

To learn more about usage of plugin, please visit the [AdcioAgent Usage documentation.](https://docs.adcio.ai/en/sdk/agent/android)
</br>

## Issues and feedback
If the plugin has issues, bugs, feedback, Please contact <dev@corca.ai>.
