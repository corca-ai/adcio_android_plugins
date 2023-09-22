#  adcio_core
[![Analytics mavencentral badge](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_core.svg)](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_core) 

A Android plugin that stores and provides resources commonly used by ADCIO.  
Because all plugins in ADCIO depend on adcio_core, the function of adcio_core must be called first.

To learn more about ADCIO, please visit the [ADCIO website](https://www.adcio.ai/)

## Getting Started
To get started with ADCIO account, please register [ADCIO account](https://app.adcio.ai/en/)

## Usage
There is a simple use example:
```kotlin
import com.corcaai.adcio_core.feature.AdcioCore

class CoreActivity : AppCompatActivity() {
    
    ...
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // this is important to call `AdcioCore.init(clientId: 'ADCIO_STORE_ID')` function.
        AdcioCore.init("67592c00-a230-4c31-902e-82ae4fe71866")
    }
}
```
To learn more about usage of plugin, please visit the [AdcioCore Usage documentation.](https://docs.adcio.ai/en/sdk/core/android)

## Issues and feedback
If the plugin has issues, bugs, feedback, Please contact <dev@corca.ai>.
