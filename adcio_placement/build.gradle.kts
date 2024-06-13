plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_placement")
    set("PUBLISH_VERSION", "1.3.0")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "adcio_placement is adcio suggestion library")
}

android {
    namespace = "ai.corca.adcio_placement"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    packagingOptions.setExcludes(
        setOf(
            "META-INF/LICENSE.md",
            "META-INF/DEPENDENCIES",
            "META-INF/LICENSE",
            "LICENSE.txt",
            "META-INF/NOTICE",
            "META-INF/MANIFEST.MF",
            "META-INF/LICENSE-notice.md"
        )
    )
    testOptions {
        packagingOptions.jniLibs {
            useLegacyPackaging = true
        }
    }
}

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")

    implementation("org.jetbrains.kotlin:kotlin-reflect")

    androidTestImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    androidTestImplementation("io.mockk:mockk-android:1.13.8")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    implementation("io.github.corca-ai:core:1.0.3")
    implementation("io.github.corca-ai:adcio_analytics:1.1.7")
}
