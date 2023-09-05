# adcio_android_plugins
'adcio_android_plugins' is a plugins that help develop 'adcio' Android services.  
The plugins can be divided into three main categories.

- `adcio_placement`: It is a plugin where you can receive **products recommended by AI** based on user information.
- `adcio_agent`: Provides an **AI assistant** that allows users to talk directly.
- `adcio_analytics`: **Collects logs** for event analysis of ADCIO projects.

</br>

# Installing
**SDK 21+ support**  
adcio_android_plugins requires a minSdkVersion of 21 or higher to use Androidx:

```groovy
android {
    defaultConfig {
        minSdkVersion 21
    }
}
```
You can download [adcio_android_plugins](https://search.maven.org/search?q=adcio) through MavenCentral.

**settings.gradle**

```groovy
repositories {
  ...
  mavenCentral()
}
```

**build.gradle (:app) - Groovy**

```groovy
dependencies {
  implementation 'io.github.corca-ai:adcio_placement:{VERSION-PLACEMENT}'
  implementation 'io.github.corca-ai:adcio_agent:{VERSION-AGENT-XML}'
  implementation 'io.github.corca-ai:adcio_agent_compose:{VERSION-AGENT-COMPOSE}'
  implementation 'io.github.corca-ai:adcio_analytics:{VERSION-ANALYTICS}'
}
```

**build.gradle (:app) - kotlin**

```kotlin
dependencies {
  implementation("io.github.corca-ai:adcio_placement:{VERSION-PLACEMENT}")
  implementation("io.github.corca-ai:adcio_agent:{VERSION-AGENT-XML}")
  implementation("io.github.corca-ai:adcio_agent_compose:{VERSION-AGENT-COMPOSE}")
  implementation("io.github.corca-ai:adcio_analytics:{VERSION-ANALYTICS}")
}
```

</br>

# adcio_placement
Android plugins that provides a ADCIO placement service.

It smartly predicts products with high click or purchase probabilities from the client's products and returns the product information.

## Sample Usage

Usually, it’s associated with the `adcio_analytics` plugin.

**get** `adcioSuggest()` **result:**

```kotlin
val adcioSuggestionRaw = AdcioPlacement.adcioSuggest(
  placementId = "...",
)
```

The `adcioSuggest()` function returns an `AdcioSuggestionRaw` object.

> Allows **internet permission** for network request.  
**Please do not call it on the UI Thread.**
> 

**parameters**: 

| name | type | desc |
| --- | --- | --- |
| placementId required | `String` | placement id. |
| otherInfo | `AdcioSuggestionInfo?` | set your device info. |
| customerId | `String?` | customer id. |
| placementPosX | `Int?` | placement position X. |
| placementPosY | `Int?` | placement position Y. |
| age | `String?` | customer age. |
| gender | `String?` | customer gender. |
| area | `String?` | customer area. |

**get device id:**

```kotlin
val deviceId: String = AdcioPlacement.getDeviceId()
```

You can obtain the `deviceId` registered through `otherInfo: AdcioSuggestionInfo`.

**get session id:**

```kotlin
val sessionId: String = AdcioPlacement.getSessionId()
```

You can obtain the `sessionId` registered through `otherInfo: AdcioSuggestionInfo`.

</br>

# adcio_agent
Android plugin that provides a ADCIO Agent widget.

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

# adcio_agent_compose
Android plugin that provides a ADCIO Agent for Jetpack Compose.

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

# adcio_analytics

Android plugin that collects logs for event analysis of ADCIO projects.

`adcio_analytics` is an app measurement solution that provides app usage and user engagement statistics.

## Sample Usage

Usually, it's associated with the `adcio_placement` plugin.

You call `adcioSuggest()` from the adcio_placement package and gather the recommended product.  
With this, you collect three types of logging events: `onClick`, `onImpression`, and `onPurchase`.

> Allows **internet permission** for network request.  
**Please do not call these functions on the UI Thread.**
> 

**AdcioImpressionDetector example:**

If a view equipped with `AdcioImpressionDetector` is exposed more than half of its size on the screen, the `onImpression` function will be called.

1. **Use in XML file.**
    
    Cover the exposed ADCIO Ad View with an `AdcioImpressionDetector`
    
    ```xml
    <ai.corca.adcio_analytics.feature.AdcioImpressionDetector
      android:id="@+id/adcioImpressionDetector"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      app:use_impression="true">
      ...
    </ai.corca.adcio_analytics.feature.AdcioImpressionDetector>
    ```
    
    > `AdcioImpressionDetector` is developed by inheriting `FrameLayout`.
    > 
    
    > **You can give** `use_impression` **as a boolean type with your view option.**  
    `true`: Call `onImpression` function when the view is more than half visible on the screen. (default)  
    `false`: play no part.
    
    You can give use_impression programmatically, too.
    > 
    > 
    > ```kotlin
    > binding.adcioImpressionDetector.useImpression = true // or false
    > ```
    > 
2. **init** `AdcioImpressionDetector`**.**
    
    ```kotlin
    binding.adcioImpressionDetector.option = logOption
    ```
    
    Register the `AdcioLogOption` in the `option` property of the `AdcioImpressionDetector` View object. 
    
    > **If you do not input an** `option`**, the** `AdcioImpressionDetector` **will not work.**
    > 

**onClick example:**

```kotlin
AdcioAnalytics.onClick(
  option = logOption
)
```

**onPurchase example:**

```kotlin
AdcioAnalytics.onPurchase(
  option = logOption
  amount: 23910 // actual purchase price
)
```

For the `onPurchase` event, you input the actual purchase price that the customer paid into price and call the event when the customer clicks the button at the purchase point.

## Features

It mainly collects three events: impression, click, and purchase.

| Event | Description | Function |
| --- | --- | --- |
| impression | 광고 노출 | AdcioAnalytics.onImpression(option) |
| click | 광고 클릭 | AdcioAnalytics.onClick(option) |
| purchase | 광고 구매 | AdcioAnalytics.onPurchase(option, amount) |

</br>

# Sample Code
- Example of the `adcio_analytics` plugin used independently
    
    https://github.com/corca-ai/adcio_android_plugins/blob/main/app/src/main/java/ai/corca/adcio_android_plugins/analytics/AnalyticsActivity.kt
    
- Example of the `adcio_placement` plugin used independently
    
    https://github.com/corca-ai/adcio_android_plugins/blob/main/app/src/main/java/ai/corca/adcio_android_plugins/placement/PlacementActivity.kt
    
- Example of the `adcio_agent` plugin used independently
    
    https://github.com/corca-ai/adcio_android_plugins/tree/main/app/src/main/java/ai/corca/adcio_android_plugins/agent
    
- You can see an app that uses three modules in combination: `adcio_analytics`, `adcio_placement`, and `adcio_agent`.
    
    https://github.com/corca-ai/adcio_demo_app_android
