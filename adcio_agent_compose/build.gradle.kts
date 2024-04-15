plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_agent_compose")
    set("PUBLISH_VERSION", "1.1.0")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "agent_compose is adcio chatbot based on LLM(GPT) for compose ui")
}

android {
    namespace = "com.corcaai.adcio_agent_compose"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.google.accompanist:accompanist-webview:0.31.6-rc")

    // compose
    implementation("androidx.compose.material:material:1.5.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.activity:activity-compose:1.7.2")
}