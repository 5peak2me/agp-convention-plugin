### [Dependency injection with Hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=zh-cn#kts)

First, add the `hilt-android-gradle-plugin` plugin to your project's root `build.gradle` file:

=== "build.gradle.kts"

    ```kotlin
    plugins {

        ··· omit ···

        id("com.google.dagger.hilt.android") version "2.44" apply false
    }
    ```
=== "build.gradle"

    ```groovy
    plugins {

        ··· omit ···

        id 'com.google.dagger.hilt.android' version '2.44' apply false
    }
    ```

Then, apply the Gradle plugin and add these dependencies in your `app/build.gradle` file:


=== "build.gradle.kts"

    ```diff
    plugins {
    -   id("com.android.application") // or id("com.android.library")
    -   id("dagger.hilt.android.plugin")
    -   id("org.jetbrains.kotlin.kapt")
    
    +   id("l3gacy.android.application") // or id("l3gacy.android.library")
    +   id("l3gacy.android.hilt")
    }
    
    android {
        namespace = "com.example"
    }
    
    dependencies {
    -   implementation("com.google.dagger:hilt-android:2.44")
    -   kapt("com.google.dagger:hilt-android-compiler:2.44")
    -   kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.44")
    
        implementation("androidx.core:core-ktx:1.9.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    }

    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }
    ```

=== "build.gradle"

    ```diff
    plugins {
    -   id 'com.android.application' // or id 'com.android.library'
    -   id 'org.jetbrains.kotlin.android'
    -   id 'dagger.hilt.android.plugin'
    
    +   id 'l3gacy.android.application' // or id 'l3gacy.android.library'
    +   id 'l3gacy.android.hilt'
    }
    
    android {
        namespace 'com.example'
    }
    
    dependencies {
    -   implementation 'com.google.dagger:hilt-android:2.44'
    -   kapt 'com.google.dagger:hilt-android-compiler:2.44'
    -   kaptAndroidTest com.google.dagger:hilt-android-compiler:2.44
    
        implementation 'androidx.core:core-ktx:1.9.0'
        implementation 'androidx.appcompat:appcompat:1.6.1'
        implementation 'com.google.android.material:material:1.9.0'
        implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
        testImplementation 'junit:junit:4.13.2'
        androidTestImplementation 'androidx.test.ext:junit:1.1.5'
        androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    }
    
    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }
    ```
    