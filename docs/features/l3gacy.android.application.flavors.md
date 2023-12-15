=== "build.gradle.kts"

    ```diff
    plugins {
    -   id("com.android.application")
    -   id("org.jetbrains.kotlin.android")

    +   id("l3gacy.android.application")
    +   id("l3gacy.android.application.flavors")
    }

    android {
        namespace = "com.example"

        ··· omit ···

    -   productFlavors {
    -       demo {
    -           applicationIdSuffix = ".demo"
    -           dimension = "contentType"
    -       }
    -       prod {
    -           applicationIdSuffix = ""
    -       }
    -   }

    }
    ```


=== "build.gradle"

    ```diff
    plugins {
    -   id 'com.android.application'
    -   id 'org.jetbrains.kotlin.android'

    +   id 'l3gacy.android.application'
    +   id 'l3gacy.android.application.flavors'
    }

    android {
        namespace 'com.example'

        ··· omit ···

    -   productFlavors {
    -       demo {
    -           applicationIdSuffix = ".demo"
    -           dimension = "contentType"
    -       }
    -       prod {
    -           applicationIdSuffix = ""
    -       }
    -   }

    }
    ```

The current `flavor` configuration code is as follows.

```kotlin
@Suppress("EnumEntryName")
enum class FlavorDimension {
    contentType,
}

// The content for the app can either come from local static data which is useful for demo
// purposes, or from a production backend server which supplies up-to-date, real content.
// These two product flavors reflect this behaviour.
@Suppress("EnumEntryName")
enum class Flavor(val dimension: FlavorDimension, val applicationIdSuffix: String? = null) {
    demo(FlavorDimension.contentType, applicationIdSuffix = ".demo"),
    prod(FlavorDimension.contentType),
}

fun configureFlavors(
    commonExtension: AndroidExtension,
    flavorConfigurationBlock: ProductFlavor.(flavor: Flavor) -> Unit = {},
) {
    commonExtension.apply {
        flavorDimensions += FlavorDimension.contentType.name
        productFlavors {
            Flavor.values().forEach {
                create(it.name) {
                    dimension = it.dimension.name
                    flavorConfigurationBlock(this, it)
                    if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (it.applicationIdSuffix != null) {
                            applicationIdSuffix = it.applicationIdSuffix
                        }
                    }
                }
            }
        }
    }
}
```