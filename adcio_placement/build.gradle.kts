import org.openapitools.generator.gradle.plugin.tasks.GenerateTask
import de.undercouch.gradle.tasks.download.Download
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

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

val basePackage = "ai.corca.placement"
val targetDir = "${project.rootDir}/generator-placement"  // Use buildDir for generated sources
val targetFileName = "placement-swagger.json"

tasks.register<Download>("downloadSwagger") {
    src("https://api.adcio.ai/api-json")
    dest(file("$targetDir/$targetFileName"))
    onlyIfModified(true)
    useETag(true)
}

tasks.register("postProcessGeneratedCode") {
    doLast {
        val generatedFilesDir = Paths.get("$targetDir/src/main/java")
        Files.walk(generatedFilesDir).filter { Files.isRegularFile(it) }.forEach { filePath ->
            val content = Files.readString(filePath, StandardCharsets.UTF_8)
            val modifiedContent = content.replace("val name: String", "val bannerName: String")
            Files.writeString(filePath, modifiedContent, StandardOpenOption.TRUNCATE_EXISTING)
        }
    }
}

tasks.register<GenerateTask>("generateClient") {
    dependsOn(tasks.named("downloadSwagger"))
    generatorName.set("kotlin")
    inputSpec.set("$targetDir/$targetFileName")
    outputDir.set("$targetDir/src/main/java")
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

tasks.named("generateClient") {
    finalizedBy(tasks.named("postProcessGeneratedCode"))
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    dependsOn(tasks.named("generateClient"))
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
    packagingOptions {
        resources {
            excludes += setOf(
                "META-INF/LICENSE.md",
                "META-INF/DEPENDENCIES",
                "META-INF/LICENSE",
                "LICENSE.txt",
                "META-INF/NOTICE",
                "META-INF/MANIFEST.MF",
                "META-INF/LICENSE-notice.md"
            )
        }
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }

    // Add the generated sources to the main source set
    sourceSets["main"].java.srcDir("$targetDir/src/main/java")
}

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("io.github.corca-ai:core:1.0.3")

    implementation(project(":generator-placement"))
}
