### [The JaCoCo Plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html)

=== "build.gradle.kts"

    ```diff
    plugins {
    -   id("com.android.application")
    -   id("jacoco") // or id("org.gradle.jacoco")
    
    +   id("l3gacy.android.jacoco")
    }
    
    jacoco {
        toolVersion = "0.8.9"
        reportsDirectory = layout.buildDirectory.dir('customJacocoReportDir')
    }

    tasks.jacocoTestReport {
        dependsOn(tasks.test) // tests are required to run before generating the report

        reports {
            xml.required.set(false)
            csv.required.set(false)
        }
    }
    ```

=== "build.gradle"

    ```diff
    plugins {
    -   id 'com.android.application'
    -   id 'jacoco' // or id 'org.gradle.jacoco'
    
    +   id 'l3gacy.android.jacoco'
    }
    
    jacoco {
        toolVersion = "0.8.9"
        reportsDirectory = layout.buildDirectory.dir('customJacocoReportDir')
    }
    
    jacocoTestReport {
        dependsOn test // tests are required to run before generating the report

        reports {
            xml.required = false
            csv.required = false
        }
    }
    ```

The current `jacoco` configuration code is as follows. You may need to configure the version of `jacoco` in `libs.versions.toml` again.

```kotlin
internal fun Project.configureJacoco(
    androidComponentsExtension: AndroidComponentsExtension<*, *, *>,
) {
    configure<JacocoPluginExtension> {
        toolVersion = libs.findVersion("jacoco").get().toString()
    }

    val jacocoTestReport = tasks.create("jacocoTestReport")

    androidComponentsExtension.onVariants { variant ->
        val testTaskName = "test${variant.name.capitalize()}UnitTest"

        val reportTask = tasks.register("jacoco${testTaskName.capitalize()}Report", JacocoReport::class) {
            dependsOn(testTaskName)

            reports {
                xml.required.set(true)
                html.required.set(true)
            }

            classDirectories.setFrom(
                fileTree("$buildDir/tmp/kotlin-classes/${variant.name}") {
                    exclude(coverageExclusions)
                },
            )

            sourceDirectories.setFrom(files("$projectDir/src/main/java", "$projectDir/src/main/kotlin"))
            executionData.setFrom(file("$buildDir/jacoco/$testTaskName.exec"))
        }

        jacocoTestReport.dependsOn(reportTask)
    }

    tasks.withType<Test>().configureEach {
        configure<JacocoTaskExtension> {
            // Required for JaCoCo + Robolectric
            // https://github.com/robolectric/robolectric/issues/2230
            // TODO: Consider removing if not we don't add Robolectric
            isIncludeNoLocationClasses = true

            // Required for JDK 11 with the above
            // https://github.com/gradle/gradle/issues/5184#issuecomment-391982009
            excludes = listOf("jdk.internal.*")
        }
    }
}
```