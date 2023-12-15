=== "build.gradle.kts"

    ```diff
    plugins {
    -   id("com.android.library")
    -   id("org.jetbrains.kotlin.android")

    +   id("l3gacy.android.library")
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
    -       // For AGP 4.1+
    -       isCoreLibraryDesugaringEnabled = true
    -       // For AGP 4.0
    -       // coreLibraryDesugaringEnabled = true
    -       sourceCompatibility = JavaVersion.VERSION_11
    -       targetCompatibility = JavaVersion.VERSION_11
    -   }

    -   kotlinOptions {
    -       jvmTarget = JavaVersion.VERSION_11.toString()
    -       freeCompilerArgs += listOf(
    -           "-Xopt-in=kotlin.RequiresOptIn",
    -           "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
    -           "-Xopt-in=kotlinx.coroutines.FlowPreview",
    -       )
    -   }

    }
    
    dependencies {
    -   coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.2.2")

        implementation("androidx.core:core-ktx:1.9.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    }
    ```

=== "build.gradle"

    ```diff
    plugins {
    -   id 'com.android.library'
    -   id 'org.jetbrains.kotlin.android'

    +   id 'l3gacy.android.library'
    }

    android {
        namespace 'com.example'

    -   compileSdk 33

    -   defaultConfig {
    -       minSdk 24
    -       targetSdk 33

    -       testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    -       consumerProguardFiles "consumer-rules.pro"
    -   }

    -   buildTypes {
    -       release {
    -           minifyEnabled false
    -           proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
    -       }
    -   }

    -   compileOptions {
    -       // Flag to enable support for the new language APIs
    -       coreLibraryDesugaringEnabled true
    -       // Sets Java compatibility to Java 8
    -       sourceCompatibility JavaVersion.VERSION_1_8
    -       targetCompatibility JavaVersion.VERSION_1_8
    -   }

    -   kotlinOptions {
    -       jvmTarget = '1.8'
    -   }
    }

    dependencies {
    -   coreLibraryDesugaring 'com.android.tools:desugar_jdk_libs:1.2.2'

        implementation 'androidx.core:core-ktx:1.9.0'
        implementation 'androidx.appcompat:appcompat:1.6.1'
        implementation 'com.google.android.material:material:1.8.0'
        implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
        testImplementation 'junit:junit:4.13.2'
        androidTestImplementation 'androidx.test.ext:junit:1.1.5'
        androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    }
    ```

