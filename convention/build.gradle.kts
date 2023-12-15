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
@file:Suppress("DSL_SCOPE_VIOLATION")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    alias(libs.plugins.plugin.publish)
    `maven-publish`
    alias(libs.plugins.detekt)
}

group = "com.l3gacy.plugin.gradle"
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
            id = "com.l3gacy.android.application.compose"
            displayName = "Android Application Compose Convention"
            description = "Android Application Compose Convention"
            tags.set(listOf("android compose application convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "com.l3gacy.android.application"
            displayName = "Android Application Convention"
            description = "Android Application Convention"
            tags.set(listOf("android application convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationJacoco") {
            id = "com.l3gacy.android.application.jacoco"
            displayName = "Android Application Jacoco Convention"
            description = "Android Application Jacoco Convention"
            tags.set(listOf("jacoco convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidApplicationJacocoConventionPlugin"
        }
        register("androidLibraryCompose") {
            id="com.l3gacy.android.library.compose"
            displayName = "Android Library Compose Convention"
            description = "Android Library Compose Convention"
            tags.set(listOf("android compose library convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.l3gacy.android.library"
            displayName = "Android Library Convention"
            description = "Android Library Convention"
            tags.set(listOf("android library convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryJacoco") {
            id = "com.l3gacy.android.library.jacoco"
            displayName = "Android Library Jacoco Convention"
            description = "Android Library Jacoco Convention"
            tags.set(listOf("jacoco convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidLibraryJacocoConventionPlugin"
        }
        register("androidTest") {
            id = "com.l3gacy.android.test"
            displayName = "Android Test Convention"
            description = "Android Test Convention"
            tags.set(listOf("test convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidTestConventionPlugin"
        }
        register("androidHilt") {
            id = "com.l3gacy.android.hilt"
            displayName = "Android Hilt Convention"
            description = "Android Hilt Convention"
            tags.set(listOf("hilt convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "com.l3gacy.android.room"
            displayName = "Android Room Convention"
            description = "Android Room Convention"
            tags.set(listOf("room convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidRoomConventionPlugin"
        }
        register("androidFirebase") {
            id = "com.l3gacy.android.application.firebase"
            displayName = "Android Application Firebase Convention"
            description = "Android Application Firebase Convention"
            tags.set(listOf("firebase convention"))
            implementationClass = "com.l3gacy.plugin.gradle.convention.AndroidApplicationFirebaseConventionPlugin"
        }
        register("jvmLibrary") {
            id = "com.l3gacy.jvm.library"
            displayName = "Jvm Library Convention"
            description = "Jvm Library Convention"
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
