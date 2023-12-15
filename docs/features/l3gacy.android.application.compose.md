=== "build.gradle.kts"

    ```diff
    plugins {
    -    id("com.android.application")
    -    id("org.jetbrains.kotlin.android")
    
    +    id("l3gacy.android.application")
    +    id("l3gacy.android.application.compose")
    }
    
    android {
        namespace = "com.l3gacy.app.myapplication"
    
    -   buildFeatures {
    -       compose = true
    -   }
    
    -   composeOptions {
    -       kotlinCompilerExtensionVersion = "1.4.8"
    -   }
    
    -   kotlinOptions {
    -       jvmTarget = "1.8"
    -   }
        
    }
    
    dependencies {
    -   val composeBom = platform("androidx.compose:compose-bom:2023.06.01")
    -   implementation(composeBom)
    -   androidTestImplementation(composeBom)
    
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
    -    id("com.android.application")
    -    id("org.jetbrains.kotlin.android")
    
    +    id 'l3gacy.android.application'
    +    id 'l3gacy.android.application.compose'
    }
    
    android {
        namespace = "com.l3gacy.app.myapplication"
    
    -   buildFeatures {
    -       compose true
    -   }
    
    -   composeOptions {
    -       kotlinCompilerExtensionVersion = "1.4.8"
    -   }
    
    -   kotlinOptions {
    -       jvmTarget = "1.8"
    -   }
        
    }
    
    dependencies {
    -   def composeBom = platform('androidx.compose:compose-bom:2023.06.01')
    -   implementation composeBom
    -   androidTestImplementation composeBom
    
        implementation("androidx.core:core-ktx:1.9.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    }
    ```