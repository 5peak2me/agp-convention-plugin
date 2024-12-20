/*
 * Copyright © 2023 J!nl!n™ Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    alias(libs.plugins.plugin.publish)
    `maven-publish`
    alias(libs.plugins.detekt)
}

group = "com.github.5peak2me.plugin.gradle"
version = "0.0.1"

// Configure the gradle-convention plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.firebase.performance.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
//    compileOnly(libs.kotlinx.compatibility.gradlePlugin)
}

@Suppress("UnstableApiUsage")
gradlePlugin {
    website.set("https://daijinlin.com/agp-convention-plugin")
    vcsUrl.set("https://github.com/5peak2me/agp-convention-plugin")

    plugins {
        register("androidApplicationCompose") {
            id = "com.5peak2me.android.application.compose"
            displayName = "Android Application Compose Convention"
            description = "Android Application Compose Convention with common module configurations."
            tags.set(listOf("android compose application convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "com.5peak2me.android.application"
            displayName = "Android Application Convention"
            description = "Android Application Convention with common module configurations."
            tags.set(listOf("android application convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationJacoco") {
            id = "com.5peak2me.android.application.jacoco"
            displayName = "Android Application Jacoco Convention"
            description = "Android Application Jacoco Convention with common module configurations."
            tags.set(listOf("jacoco convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidApplicationJacocoConventionPlugin"
        }
        register("androidLibraryCompose") {
            id="com.5peak2me.android.library.compose"
            displayName = "Android Library Compose Convention"
            description = "Android Library Compose Convention with common module configurations."
            tags.set(listOf("android compose library convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.5peak2me.android.library"
            displayName = "Android Library Convention"
            description = "Android Library Convention with common module configurations."
            tags.set(listOf("android library convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryJacoco") {
            id = "com.5peak2me.android.library.jacoco"
            displayName = "Android Library Jacoco Convention"
            description = "Android Library Jacoco Convention with common module configurations."
            tags.set(listOf("jacoco convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidLibraryJacocoConventionPlugin"
        }
        register("androidTest") {
            id = "com.5peak2me.android.test"
            displayName = "Android Test Convention"
            description = "Android Test Convention with common module configurations."
            tags.set(listOf("test convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidTestConventionPlugin"
        }
        register("androidHilt") {
            id = "com.5peak2me.android.hilt"
            displayName = "Android Hilt Convention"
            description = "Android Hilt Convention with common module configurations."
            tags.set(listOf("hilt convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "com.5peak2me.android.room"
            displayName = "Android Room Convention"
            description = "Android Room Convention with common module configurations."
            tags.set(listOf("room convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidRoomConventionPlugin"
        }
        register("androidFirebase") {
            id = "com.5peak2me.android.application.firebase"
            displayName = "Android Application Firebase Convention"
            description = "Android Application Firebase Convention with common module configurations."
            tags.set(listOf("firebase convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidApplicationFirebaseConventionPlugin"
        }
        register("jvmLibrary") {
            id = "com.5peak2me.jvm.library"
            displayName = "Jvm Library Convention"
            description = "Jvm Library Convention with common module configurations."
            tags.set(listOf("jvm convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.JvmLibraryConventionPlugin"
        }
    }
}

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = false // activate all available (even unstable) rules.
    config.setFrom("$rootDir/config/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
        xml.required.set(false) // checkstyle like format mainly for integrations like Jenkins
        txt.required.set(false) // similar to the console output, contains issue signature to manually edit baseline files
        sarif.required.set(false) // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with GitHub Code Scanning
        md.required.set(true) // simple Markdown format
    }
}
