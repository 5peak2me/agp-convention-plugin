/*
 * Copyright © 2020-2023 J!nl!n™ Inc. All rights reserved.
 *
 * Copyright 2022 The Android Open Source Project
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
package com.l3gacy.plugin.gradle.convention

import com.android.build.gradle.TestExtension
import com.l3gacy.plugin.gradle.convention.internal.configureGradleManagedDevices
import com.l3gacy.plugin.gradle.convention.internal.configureKotlinAndroid
import com.l3gacy.plugin.gradle.convention.internal.targetSdk
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<TestExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = project.targetSdk
                configureGradleManagedDevices(this)
            }
        }
    }
}
