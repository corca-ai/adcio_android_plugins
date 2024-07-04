import org.gradle.kotlin.dsl.android

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "ai.corca.generator_analytics"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    dependencies {
        val kotlin_version = "1.7.21"
        val retrofitVersion = "2.9.0"

        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")
        implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
        implementation("com.squareup.moshi:moshi-adapters:1.13.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
        implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
        implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
        implementation("com.squareup.retrofit2:converter-scalars:$retrofitVersion")
        testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    }
}
