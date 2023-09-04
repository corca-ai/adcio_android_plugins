# adcio_agent_compose

Android plugin that provides a ADCIO Agent_JetpackCompose widget

**SDK 21+ support**


## Installation
Add `adcio_agent_compose` as a dependency in your module’s build.gradle


## Usage
The agent requires a minSdkVersion of 21 or higher to use Androidx:

```groovy
android {
    defaultConfig {
        minSdkVersion 21
    }
}
```


### ADCIO Agent Compose Sample Code
**Super simple usage: callAdcioAgent composable and specify modifier**

```kotlin
@Composable
fun agentScreen() {
   Column(
      modifier = Modifier.fillMaxSize()
   ) {
        ...
        callAdcioAgent(
           modifier = Modifier.fillMaxSize(), // Agent Size Modifier
           clientId = "YOUR_CLIENT_ID", // Your Adcio Client ID
        )
    }
}
```

| property | description | type | default |
| --- | --- | --- | --- |
| modifier | Agent Layout Control | Modifier | fillMaxSize() |
| clientId | : ~ adcio admin | String | required |
| showAppBar | Agent show AppBar | boolean | false |

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


**isAgentStartPage**

Returns whether the current page is the first page of the agent's page.

```kotlin
val agent = AdcioAgentCompose()

val isPageStart: Boolean = agent.isAgentStartPage()
```

**agentGoback**

An action to navigate back to the previous page in the agent's page.

**Important: If you use the app's own AppBar to enable POP of the AppBar's WebView, You must enable the following settings:**

```kotlin
...
val agent = AdcioAgentCompose()

// YOUR APPBAR BackButton
Button(
   onClick = { 
       onBackPressedDispatcher.onBackPressed() // IMPORTANT THING TO DO
       agent.agentGoBack
   }
)
...
```