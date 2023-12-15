/*
 * Copyright 2023 The Android Open Source Project
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
package com.l3gacy.plugin.gradle.convention.internal

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.VersionConstraint
import org.gradle.kotlin.dsl.getByType
import java.util.Locale

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

private const val TARGET_SDK = "targetSdk"
private const val COMPILE_SDK = "compileSdk"
private const val MIN_SDK = "minSdk"

internal val Project.targetSdk
    get() = findVersion(TARGET_SDK).toString().toIntOrNull()

internal val Project.compileSdk
    get() = findVersion(COMPILE_SDK).toString().toIntOrNull()

internal val Project.minSdk: Int?
    get() = findVersion(MIN_SDK).toString().toIntOrNull()

//internal val Project.minSdk: Int? by LazyWithReceiver<Project, Int?> {
//    findVersion(MIN_SKD).toString().toIntOrNull()
//}

private fun Project.findVersion(name: String): VersionConstraint {
    return if (libs.findVersion(name).isPresent) {
        libs.findVersion(name)
    } else {
        libs.findVersion(name.lowercase(Locale.getDefault()))
    }.get()
}

//internal fun Project.findLibrary(name: String): Provider<MinimalExternalModuleDependency> {
//    return if (libs.findLibrary(name).isPresent) {
//        libs.findLibrary(name)
//    } else {
//        libs.findLibrary(name.lowercase(Locale.getDefault()))
//    }.get()
//}

internal typealias AndroidExtension = com.android.build.api.dsl.CommonExtension<*, *, *, *, *>

fun String.camelToSnakeCase(): String {
    val pattern = "(?<=.)[A-Z]".toRegex()
    return this.replace(pattern, "_$0").lowercase()
}

fun String.camelToSnakeCaseNoRegex(): String {
    return this.fold(StringBuilder()) { acc, c ->
        acc.let {
            val lowerC = c.lowercase()
            acc.append(if (acc.isNotEmpty() && c.isUpperCase()) "_$lowerC" else lowerC)
        }
    }.toString()
}

fun String.snakeToCamelCase(): String {
    val pattern = "_[a-z]".toRegex()
    return replace(pattern) { it.value.last().uppercase() }
}

fun String.snakeToCamelCase2(): String {
    val pattern = "_([a-z])".toRegex()
    return replace(pattern) { it.groupValues[1].uppercase() }
}
