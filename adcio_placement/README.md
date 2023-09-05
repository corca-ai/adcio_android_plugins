# adcio_placement
Android plugins that provides a ADCIO placement service.

It smartly predicts products with high click or purchase probabilities from the client's products and returns the product information.
</br>

## Installing

**groovy**
```groovy
implementation 'io.github.corca-ai:adcio_placement:{VERSION-PLACEMENT}'
```

**kotlin**
```kotlin
implementation("io.github.corca-ai:adcio_placement:{VERSION-PLACEMENT}")
```
</br>

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
</br>

**parameters**: 

| property | description | type | default |
| --- | -- | --- | --- |
| placementId | Your Placement Id | String | required |
| otherInfo | Your Device Info | AdcioSuggestionInfo? | null |
| customerId | Customer Id | String? | null |
| placementPosX | placement position X | Int? | null |
| placementPosY | placement position Y | Int? | null |
| age | customer age | String? | null |
| gender | customer gender | String? | null |
| area | customer area | String? | null |

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
