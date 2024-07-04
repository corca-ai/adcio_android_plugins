import org.openapitools.generator.gradle.plugin.tasks.GenerateTask
import de.undercouch.gradle.tasks.download.Download

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
    id("org.openapi.generator")
    id("de.undercouch.download")
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_placement")
    set("PUBLISH_VERSION", "1.3.2")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "adcio_placement is adcio suggestion library")
}

val basePackage = "ai.corca.adcio_placement"
val targetDir = "${project.rootDir}/placement-generated-sources"
val targetFileName = "placement-swagger.json"

tasks.register<Download>("downloadSwagger") {
    src("https://api.adcio.ai/api-json")
    dest(file("$targetDir/$targetFileName"))
    onlyIfModified(true)
    useETag(true)
}

tasks.register<GenerateTask>("generateClient") {
    dependsOn(tasks.named("downloadSwagger"))
    generatorName.set("kotlin")
    inputSpec.set("$targetDir/$targetFileName")
    outputDir.set(targetDir)
    apiPackage.set("$basePackage.api")
    modelPackage.set("$basePackage.model")
    invokerPackage.set("$basePackage.invoker")
    configOptions.set(
        mapOf(
            "library" to "jvm-retrofit2",
            "dateLibrary" to "java11",
            "omitGradleWrapper" to "true",
            "sourceFolder" to "src/main/java",
            "useCoroutines" to "false"
        )
    )
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

    sourceSets["main"].java.srcDirs("$targetDir/src/main/java")
}

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("io.github.corca-ai:core:1.0.3")
}
