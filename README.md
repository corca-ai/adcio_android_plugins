# adcio_android_plugins
'adcio_android_plugins' is a plugins that help develop 'adcio' Android services.  
The plugins can be divided into three main categories.

- `adcio_analytics`: **Collects logs** for event analysis of ADCIO projects.
- `adcio_placement`: It is a plugin where you can receive **products recommended by AI** based on user information.
- `adcio_agent`: Provides an **AI assistant** that allows users to talk directly.

</br>

| Name                   | MavenCentral                                                                                                                                                                                                                                                                                                      | Documentation                                                     | View Source  
|------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------:|
| adcio_analytics              | ![Maven Central](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_analytics)   | [📖](https://github.com/corca-ai/adcio_android_plugins/blob/develop/adcio_analytics/README.md)| [`adcio_analytics`](https://github.com/corca-ai/adcio_android_plugins/tree/develop/adcio_analytics)
| adcio_placement              | ![Maven Central](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_placement)     | [📖](https://github.com/corca-ai/adcio_android_plugins/blob/develop/adcio_placement/README.md)| [`adcio_placement`](https://github.com/corca-ai/adcio_android_plugins/tree/develop/adcio_placement)
| adcio_agent              | ![Maven Central](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_agent) | [📖](https://github.com/corca-ai/adcio_android_plugins/blob/develop/adcio_agent/README.md)| [`adcio_agent`](https://github.com/corca-ai/adcio_android_plugins/tree/develop/adcio_agent)       
| adcio_agent_compose| ![Maven Central](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_agent_compose)  | [📖](https://github.com/corca-ai/adcio_android_plugins/blob/develop/adcio_agent_compose/README.md)| [`adcio_agent_compose`](https://github.com/corca-ai/adcio_android_plugins/tree/develop/adcio_agent_compose)           
</br>

# Installing
### 1. SDK 21+ support
adcio_android_plugins requires a minSdkVersion of 21 or higher to use Androidx:

```groovy
android {
    defaultConfig {
        minSdkVersion 21
    }
}
```

</br>

### 2. add [adcio_android_plugins through MavenCentral](https://central.sonatype.com/namespace/io.github.corca-ai).

**1\) Add the code below within `settings.gradle`**

```groovy
repositories {
  ...
  mavenCentral()
}
```

**2\) Add the following to app-level `build.gradle`**

Groovy
```groovy
dependencies {
  implementation 'io.github.corca-ai:adcio_placement:{VERSION-PLACEMENT}'
  implementation 'io.github.corca-ai:adcio_agent:{VERSION-AGENT}'
  implementation 'io.github.corca-ai:adcio_agent_compose:{VERSION-AGENT-COMPOSE}'
  implementation 'io.github.corca-ai:adcio_analytics:{VERSION-ANALYTICS}'
}
```

Kotlin
```kotlin
dependencies {
  implementation("io.github.corca-ai:adcio_placement:{VERSION-PLACEMENT}")
  implementation("io.github.corca-ai:adcio_agent:{VERSION-AGENT}")
  implementation("io.github.corca-ai:adcio_agent_compose:{VERSION-AGENT-COMPOSE}")
  implementation("io.github.corca-ai:adcio_analytics:{VERSION-ANALYTICS}")
}
```


  
    
   
