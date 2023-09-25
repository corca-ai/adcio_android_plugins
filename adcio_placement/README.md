#  adcio_placement
[![Analytics mavencentral badge](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_placement.svg)](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_placement) 

Android plugin that provides a ADCIO placement service. <br />
It smartly predicts products with high click or purchase probabilities from the client's products and returns the product information.

To learn more about ADCIO, please visit the [ADCIO website](https://www.adcio.ai/)
</br>

## Getting Started
To get started with ADCIO account, please register [ADCIO account](https://app.adcio.ai/en/)
</br>

## Usage

Usually, it’s associated with the `adcio_analytics` plugin.

**get** `adcioSuggest()` **result:**

```kotlin
val adcioSuggestionRaw = AdcioPlacement.adcioSuggest(
  placementId = "...",
)
```

The `adcioSuggest()` function returns an `AdcioSuggestionRaw` object.

To learn more about usage of plugin, please visit the [AdcioPlacement Usage documentation.](https://docs.adcio.ai/en/sdk/suggestions/android)
</br>

## Issues and feedback
If the plugin has issues, bugs, feedback, Please contact <dev@corca.ai>.
