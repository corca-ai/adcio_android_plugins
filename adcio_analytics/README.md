#  adcio_analytics
[![Analytics mavencentral badge](https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_analytics.svg)](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_analytics) 

Android plugin that collects logs for event analysis of ADCIO projects.

To learn more about ADCIO, please visit the [ADCIO website](https://www.adcio.ai/)
</br>

## Getting Started
To get started with ADCIO account, please register [ADCIO account](https://app.adcio.ai/en/)
</br>

## Usage

**AdcioImpressionDetector example:**

If a view equipped with `AdcioImpressionDetector` is exposed more than half of its size on the screen, the `onImpression` function will be called.

**Use in XML file.**

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

**onPageView example:**

```kotlin
AdcioAnalytics.onPageView(
  path = "main"
)
```
Called every time a screen is created
</br>

## Features

It mainly collects three events: impression, click, and purchase.

| Event | Function |
| --- | --- |
| impression | AdcioAnalytics.onImpression(option) |
| click | AdcioAnalytics.onClick(option) |
| purchase | AdcioAnalytics.onPurchase(option, amount) |
| pageView | AdcioAnalytics.onPageView(path) |


To learn more about usage of plugin, please visit the [AdcioAnalytics Usage documentation.](https://docs.adcio.ai/en/sdk/log-collection/android)
</br>

## Issues and feedback
If the plugin has issues, bugs, feedback, Please contact <dev@corca.ai>.
