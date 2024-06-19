plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "ai.corca.dacs"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(kotlin("stdlib"))
    
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.aallam.openai:openai-client:3.7.2")

    implementation("io.ktor:ktor-client-core:2.3.2")
    implementation("io.ktor:ktor-client-okhttp:2.0.1")
    implementation("io.ktor:ktor-client-serialization:2.0.1")
    runtimeOnly("io.ktor:ktor-client-okhttp:2.0.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.2")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.2")
    implementation("io.ktor:ktor-client-logging:2.3.2")
    implementation("io.ktor:ktor-client-auth:2.3.2")

    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")

    implementation ("org.eclipse.jgit:org.eclipse.jgit:5.13.0.202109080827-r")
}