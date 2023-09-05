# adcio_analytics

Android plugin that collects logs for event analysis of ADCIO projects.

`adcio_analytics` is an app measurement solution that provides app usage and user engagement statistics.
</br>

## Installing

**groovy**
```groovy
implementation 'io.github.corca-ai:adcio_analytics:{VERSION-ANALYTICS}'
```

**kotlin**
```kotlin
implementation("io.github.corca-ai:adcio_analytics:{VERSION-ANALYTICS}")
```
</br>

## Sample Usage

Usually, it's associated with the `adcio_placement` plugin.

You call `adcioSuggest()` from the adcio_placement package and gather the recommended product.  
With this, you collect three types of logging events: `onClick`, `onImpression`, and `onPurchase`.

> Allows **internet permission** for network request.  
**Please do not call these functions on the UI Thread.**
> 
</br>

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
</br>

**onClick example:**

```kotlin
AdcioAnalytics.onClick(
  option = logOption
)
```
</br>

**onPurchase example:**

```kotlin
AdcioAnalytics.onPurchase(
  option = logOption
  amount: 23910 // actual purchase price
)
```

For the `onPurchase` event, you input the actual purchase price that the customer paid into price and call the event when the customer clicks the button at the purchase point.
</br>

## Features

It mainly collects three events: impression, click, and purchase.

| Event | Function |
| --- | --- |
| impression | AdcioAnalytics.onImpression(option) |
| click | AdcioAnalytics.onClick(option) |
| purchase | AdcioAnalytics.onPurchase(option, amount) |

</br>
