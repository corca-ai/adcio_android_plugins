# adcio_agent
Provides an **AI assistant** that allows users to talk directly.

This is an artificial intelligence chatbot used in `XML` view operation method.
</br>

## Installing

**groovy**
```groovy
implementation 'io.github.corca-ai:adcio_agent:{VERSION-AGENT}'
```

**kotlin**
```kotlin
implementation("io.github.corca-ai:adcio_agent:{VERSION-AGENT}")
```
</br>

## Sample Usage
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
class XmlActivity : AppCompatActivity() {

  private val agent = AdcioAgent(
    context = this,
    clientId = "YOUR_CLIENT_ID",
    fragmentContainer = R.id.adcio_agent_frame,
  )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_xml)
    agent.callAdcioAgent()
  }
}
```

| property | description | type | default |
| --- | -- | --- | --- |
| context | Activity Context | `Context` | required |
| clientId | Your Adcio Client Id | `String` | required |
| fragmentContainer | AdcioAgentLayout ResId | `int` | required |
| showAppBar | Agent show AppBar | `boolean` | false |

</br>

**Get ID of clicked product:**  
fetchProductId sample when product clicked

```kotlin
adcioAgentListener = object : AdcioAgentListener {

  override fun onClickProductId(productId: String) {

    // An example of a Toast for productId.
    Toast.makeText(this@XmlActivity, productId, Toast.LENGTH_SHORT).show()

    // An example of screen movement for productId.
    val intent = Intent(this@XmlActivity, SecondActivity::class.java)
    intent.putExtra("productId", productId)
    startActivity(intent)
  }
}
```

</br>

**Check if the Agent is the Start Page:**  
Returns whether the current page is the first page of the agent's page.

```kotlin
val agent = AdcioAgent(..)

val isPageStart: Boolean = agent.isAgentStartPage()
```

</br>

**Back within agent page:**  
Action to navigate back to the previous page in the agent's page.

**Important: If you use the app's own AppBar to enable POP of the AppBar's WebView, </br>
  You must enable the following settings:**

```kotlin
val agent = AdcioAgent(..)

binding.btnBack.setOnClickListener {
  onBackPressedDispatcher.onBackPressed() // IMPORTANT THING TO DO
  agent.agentGoBack()
}
```

</br>
