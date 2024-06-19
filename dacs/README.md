# Install

### Add Dependency on [adcio_analytics](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_analytics), [adcio_placemenet](https://central.sonatype.com/artifact/io.github.corca-ai/adcio_placement)

Add the following dependency to `/app/build.gradle` file.
This library is distributed in the mavenCentral library repository. Below is the latest version of ADCIO SDK. Please add the dependency of `analytics` and `placement` with that version.

https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_analytics

```groovy
implementation 'io.github.corca-ai:adcio_analytics:{VERSION}' // GROOVY
implementation("io.github.corca-ai:adcio_analytics:{VERSION}") // KTS
```

https://img.shields.io/maven-central/v/io.github.corca-ai/adcio_placement

```kotlin
implementation 'io.github.corca-ai:adcio_placement:{VERSION}' // GROOVY
implementation("io.github.corca-ai:adcio_placement:{VERSION}") // KTS
```

### Add Permission

Allows **internet permission** for network request.

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

---

# **Initialize ADCIO Object**

<aside>
💡 We recommend that they are created/destroyed along with the lifecycle of the View.

</aside>

### ADCIO Analytics

```kotlin
import ai.corca.adcio_analytics.feature.AdcioAnalytics

val adcioAnalytics = AdcioAnalytics(clientId: "SAMPLE_CLIENT_ID") // Create instance

fun exampleAction() {
    adcioAnalytics.onPurchase(
        ...
    )
    adcioAnalytics.onClick(
        ...
    )
}
```

### ADCIO Placement

ADCIO Placement is an Object class, so you don't need to initialise it, just use it

```kotlin
fun exampleAction() {
    val adcioSuggestionRaw = AdcioPlacement.createRecommendationProducts(
        ...
    )
}
```

For information on how to get the clientId, please [refer here](https://docs.adcio.ai/en/docs/get-started/integration)

---

# **Use LogOptions**

Log functions where option is used use the response value of methods of adcio_placement.

**RecommendationBanners**

```kotlin
val adcioSuggestionRaw = AdcioPlacement.createRecommendationBanners(
    clientId = "CLIENT_ID",
    placementId = "PLACEMENT_ID",
    fromAgent: false,
    customerId = currentUser.id,
    birthYear = currentUser.birthDate.year,
    gender = Gender.male,
)
```

**RecommendationProducts**

```kotlin
val adcioSuggestionRaw = AdcioPlacement.createRecommendationProducts(
    clientId = "CLIENT_ID",
    placementId = "PLACEMENT_ID",
    categoryId = "CATEGORY_ID",
    excludingProductIds = listOf("1001"),
    customerId = currentUser.id,
    fromAgent: false,
    birthYear = currentUser.birthDate.year,
    gender = Gender.male,
    filters = mapOf(
        "price_excluding_tax" to Filters(not = 53636),
        "product_code" to Filters(contains = "KY"),
        "province_id" to Filters(equalTo = 1)
    ),
    sibalID: String
)
```

**AdvertisementBanners**

```kotlin
val adcioSuggestionRaw = AdcioPlacement.createAdvertisementBanners(
    clientId = "CLIENT_ID",
    placementId = "PLACEMENT_ID",
    fromAgent: false,
    customerId = currentUser.id,
    birthYear = currentUser.birthDate.year,
    gender = Gender.male,
)
```

**AdvertisementProducts**

```kotlin
val adcioSuggestionRaw = AdcioPlacement.createAdvertisementProducts(
    clientId = "CLIENT_ID",
    placementId = "PLACEMENT_ID",
    categoryId = "CATEGORY_ID",
    excludingProductIds = listOf("1001"),
    customerId = currentUser.id,
    fromAgent: false,
birthYear = currentUser.birthDate.year,
gender = Gender.male,
filters = mapOf(
    "price_excluding_tax" to Filters(not = 53636),
    "product_code" to Filters(contains = "KY"),
    "province_id" to Filters(equalTo = 1)
),
)
```

---

## Log Collections

### **Impression**

Called when a product recommended as a `suggestion` has at least 50% exposure on the screen for at least 1 second. Please refer [here](https://docs.adcio.ai/en/docs/concepts/log-collection#impression).

```kotlin
val adcioAnalytics = AdcioAnalytics("CLIENT_ID")

adcioAnalytics.onImpression(
    option = logOption,
    customerID: null,
productIDOnStore: null
)
```

### **Click**

It is called when customer clicks on the product recommended by the `suggestion`.

```kotlin
val adcioAnalytics = AdcioAnalytics("CLIENT_ID")

adcioAnalytics.onClick(
    option = logOption,
    customerId = null,
    productIdOnStore = null
)
```

### **Purchase**

This should be called when a customer purchases a product recommended by a `suggestion`.

For `amount`, enter the actual price of the customer's final purchase. And as `orderID`, enter the order ID you are using within your store service.

```kotlin
val adcioAnalytics = AdcioAnalytics("CLIENT_ID")

adcioAnalytics.onPurchase(
    orderId = orderId,
    productIdOnStore = "productIdOnStore",
    amount = amount,
    categoryIdOnStore = null,
    customerId = null,
    option = null,
    quantity = null,
)
```

### **AddToCart**

This is a function to collect data on purchase conversion rate after adding to the shopping cart. It should be called when a customer adds an item to their shopping cart.

For `cartID` (optional), enter the unique ID of the shopping cart you are using within your store service, if you have.

```kotlin
val adcioAnalytics = AdcioAnalytics("CLIENT_ID")

adcioAnalytics.onAddToCart(
    productIdOnStore = "productIdOnStore",
    customerId = null,
    categoryIdOnStore = null,
    cartId = null,
    option = null,
    quantity = null,
)
```

### **View**

It should be called when the screen is created and converted.

For `productIdOnStore` or `categoryIdOnStore`, please enter the name of the page you are using within your store service.

`idOnStore` means the identifier that is unique on store’s system. Please refer [here](https://docs.adcio.ai/en/docs/concepts/log-collection#id-and-idonstore).

```kotlin
val adcioAnalytics = AdcioAnalytics("CLIENT_ID")

adcioAnalytics.onPageView(
    productIdOnStore = "productIdOnStore",
    categoryIdOnStore = null,
    option = null,
    customerId = null,
)
```

---

# Demo

### Suggestion Example

[adcio_android_plugins/app/src/main/java/ai/corca/adcio_android_plugins/suggestion at main · corca-ai/adcio_android_plugins](https://github.com/corca-ai/adcio_android_plugins/tree/main/app/src/main/java/ai/corca/adcio_android_plugins/suggestion)
