# adcio_agent_xml

Android plugin that provides a ADCIO Agent widget

|  | Android |
| --- | --- |
| Support | minSdk 21+ |

## Installation

Add `adcio_agent_compose` as a dependency in your module’s build.gradle

## Usage

You should however make sure to set the correct `minSdkVersion` in `android/app/build.gradle` if it was previously lower than 21:

```groovy
android {
    defaultConfig {
        minSdkVersion 21
    }
}
```

### ADCIO Agent View Sample Code

You should make `<AdcioAgentLayout>` the space where Agent will be placed

```xml
<androidx.constraintlayout.widget.ConstraintLayout>

		...

    <ai.corca.adcio_agent.layout.AdcioAgentLayout
        android:id="@+id/adcio_agent_frame"
        ...
    />

</androidx.constraintlayout.widget.ConstraintLayout>
```

Activity Sample Code ( Activity )

```kotlin
class XmlActivity : AppCompatActivity() {

	...

	private val agent = AdcioAgent(
	    context = this, // Activity Context
	    clientId = "YOUR_CLIENT_ID", // Your Adcio Client ID
	    fragmentContainer = R.id.adcio_agent_frame, // AdcioAgentLayout Res ID
	)
	
	override fun onCreate(savedInstanceState: Bundle?) {
	    super.onCreate(savedInstanceState)
	    setContentView(R.layout.activity_xml)
	    agent.callAdcioAgent()

        ...
	}
}
```

| property | description | type | default |
| --- | --- | --- | --- |
| context | Activity Context | Context | required |
| clientId | : ~ adcio admin | String | required |
| fragmentContainer | AdcioAgentLayout ResId | int | required |
| showAppBar | Agent show AppBar | boolean | false |

### Get Clicked ProductId
fetchProductId sample when product clicked

```kotlin
adcioAgentListener = object : AdcioAgentListener {
     override fun onClickProductId(productId: String) { 
         /**
         * An example of a Toast for productId.
         */
        Toast.makeText(this@XmlActivity, productId, Toast.LENGTH_SHORT).show()

        /**
         * An example of screen movement for productId.
         */
        val intent = Intent(this@XmlActivity, SecondActivity::class.java)
        intent.putExtra("productId", productId)
        startActivity(intent)
     }
}
```

### isAgentStartPage

Returns whether the current page is the first page of the agent's page.

```kotlin
val agent = AdcioAgent(..)

val isPageStart: Boolean = agent.isAgentStartPage()
```

### agentGoback

An action to navigate back to the previous page in the agent's page.

<aside>
💡 **Important: If you use the app's own AppBar to enable POP of the AppBar's WebView, 
You must enable the following settings:**
</aside>

```kotlin
val agent = AdcioAgent(..)

binding.btnBack.setOnClickListener {
	onBackPressedDispatcher.onBackPressed()
	agent.agentGoBack()
}
```