=== "build.gradle.kts"

    ```diff
    plugins {
    -   id("com.android.test")
    -   id("org.jetbrains.kotlin.android")
        
    +   id("l3gacy.android.test")
    }

    android {
        namespace = "com.example"

    -   compileSdk = 33

    -   defaultConfig {
    -       minSdk = 24
    -       targetSdk = 33

    -       testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    -       consumerProguardFiles("consumer-rules.pro")
    -   }

    -   buildTypes {
    -       release {
    -           isMinifyEnabled = false
    -           proguardFiles(
    -               getDefaultProguardFile("proguard-android-optimize.txt"),
    -               "proguard-rules.pro"
    -           )
    -       }
    -   }

    -   compileOptions {
    -       sourceCompatibility = JavaVersion.VERSION_11
    -       targetCompatibility = JavaVersion.VERSION_11
    -       isCoreLibraryDesugaringEnabled = true
    -   }

    -   kotlinOptions {
    -       jvmTarget = JavaVersion.VERSION_11.toString()
    -       isCoreLibraryDesugaringEnabled = true
    -       freeCompilerArgs += listOf(
    -           "-Xopt-in=kotlin.RequiresOptIn",
    -           "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
    -           "-Xopt-in=kotlinx.coroutines.FlowPreview",
    -       )
    -   }
    

    }

    dependencies {
    -   coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.2.2")

        ··· omit ···
    }
    ```

=== "build.gradle"

    ```diff
    plugins {
    -   id 'com.android.test'
    -   id 'org.jetbrains.kotlin.android'
        
    +   id 'l3gacy.android.test'
    }
    ```