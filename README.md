# adcio_android_plugins
'adcio_android_plugins' is a plugins that help develop 'adcio' Android services.  
The plugins can be divided into three main categories.

- `adcio_analytics`: **Collects logs** for event analysis of ADCIO projects.
- `adcio_placement`: It is a plugin where you can receive **products recommended by AI** based on user information.
- `adcio_agent`: Provides an **AI assistant** that allows users to talk directly.

</br>

| Name                   | MavenCentral                                                                                                                                                                                                                                                                                                      | Documentation                                                     | View Source  
|------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------:|
| adcio_analytics              | [![Analytics mavencentral badge](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_analytics.svg)](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_analytics/0.0.1)    | [📖](https://github.com/corca-ai/adcio_android_plugins/blob/feature/write-document-ADCIO-1252/adcio_analytics/README.md)| [`adcio_analytics`](https://github.com/corca-ai/adcio_android_plugins/tree/develop/adcio_analytics)
| adcio_placement              | [![Analytics mavencentral badge](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_placement.svg)](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_placement/0.0.1)     | [📖](https://github.com/corca-ai/adcio_android_plugins/blob/feature/write-document-ADCIO-1252/adcio_placement/README.md)| [`adcio_placement`](https://github.com/corca-ai/adcio_android_plugins/tree/develop/adcio_placement)
| adcio_agent              | [![Analytics mavencentral badge](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_agent.svg)](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_agent/0.0.1)| [📖](https://github.com/corca-ai/adcio_android_plugins/blob/develop/adcio_agent/README.md)| [`adcio_agent`](https://github.com/corca-ai/adcio_android_plugins/tree/develop/adcio_agent)       
| adcio_agent_compose| [![Analytics mavencentral badge](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_agent_compose.svg)](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_agent_compose/0.0.1)       | [📖](https://github.com/corca-ai/adcio_android_plugins/blob/develop/adcio_agent_compose/README.md)| [`adcio_agent_compose`](https://github.com/corca-ai/adcio_android_plugins/tree/develop/adcio_agent_compose)           


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


# Sample Code
- Example of the [`adcio_analytics`](https://github.com/corca-ai/adcio_android_plugins/blob/main/app/src/main/java/ai/corca/adcio_android_plugins/analytics/AnalyticsActivity.kt) plugin used independently

    
- Example of the [`adcio_placement`](https://github.com/corca-ai/adcio_android_plugins/blob/main/app/src/main/java/ai/corca/adcio_android_plugins/placement/PlacementActivity.kt) plugin used independently
    
    
- Example of the [`adcio_agent`](https://github.com/corca-ai/adcio_android_plugins/tree/main/app/src/main/java/ai/corca/adcio_android_plugins/agent) plugin used independently

    
- You can see an app that uses three modules in combination: [`adcio_analytics`, `adcio_placement`, and `adcio_agent`](https://github.com/corca-ai/adcio_demo_app_android)
  
    
   
