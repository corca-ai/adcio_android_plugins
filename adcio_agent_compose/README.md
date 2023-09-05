# adcio_agent_compose
Provides an **AI assistant** that allows users to talk directly.

This is an artificial intelligence chatbot used in `Jetpack Compose` view operation method.

## Sample Usage
**Super simple usage: call `callAdcioAgent` in composable function and specify modifier**

```kotlin
@Composable
fun agentScreen() {
  Column(
    modifier = Modifier.fillMaxSize()
  ) {
    ...
    callAdcioAgent(
      modifier = Modifier.fillMaxSize(),
      clientId = "YOUR_CLIENT_ID",
    )
  }
}
```

| property | description | type | default |
| --- | -- | --- | --- |
| modifier | Agent Layout Control | `Modifier` | fillMaxSize() |
| clientId | Your Adcio Client Id | `String` | required |
| showAppBar | Agent show AppBar | `boolean` | false |

**Super simple get productId: Import productId and create a variable that remembers it.**

if the value of productId changes, the value of “id” will also be updated

```kotlin
import ai.corca.adcio_agent_compose.provider.productId

@Composable
fun agentScreen() {
  var id by remember { productId } 
  ...
}
```

</br>

**Check if the Agent is the Start Page:**  
Returns whether the current page is the first page of the agent's page.

```kotlin
val agent = AdcioAgentCompose()

val isPageStart: Boolean = agent.isAgentStartPage()
```

</br>

**Back within agent page:**  
An action to navigate back to the previous page in the agent's page.
</br>

**Important: If you use the app's own AppBar to enable POP of the AppBar's WebView,  
You must enable the following settings:**

```kotlin
...
val agent = AdcioAgentCompose()

// YOUR AppBar BackButton
Button(
   onClick = { 
       onBackPressedDispatcher.onBackPressed() // IMPORTANT THING TO DO
       agent.agentGoBack()
   }
)
...
```

</br>
