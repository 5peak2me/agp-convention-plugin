=== "build.gradle.kts"

    ```diff
    plugins {
        id("com.android.application")
        
    -   id("com.google.gms.google-services")
    -   id("com.google.firebase.crashlytics")
    -   id("com.google.firebase.perf")

    +   id("l3gacy.android.application.firebase")
    }
    
    android {
        namespace 'com.example'
        
        ··· omit ···
        
    -   buildTypes {
    -       debug {
    -           firebaseCrashlytics {
    -               mappingFileUploadEnabled = true
    -           }
    -           crashlytics {
    -               mappingFileUploadEnabled = true
    -           }
    -       }
    -   }

    }
    
    dependencies {
    
    -   implementation(platform("com.google.firebase:firebase-bom:26.8.0"))
    -   implementation("com.google.firebase:firebase-analytics")
    -   implementation("com.google.firebase:firebase-crashlytics")
    -   implementation("com.google.firebase:firebase-perf")
    
        ··· omit ···
    }
    ```

=== "build.gradle"

    ```diff
    plugins {
        id 'com.android.application'
        
    -   id 'com.google.gms.google-services'
    -   id 'com.google.firebase.crashlytics'
    -   id 'com.google.firebase.perf'

    +   id 'l3gacy.android.application.firebase'
    }
    
    android {
        namespace 'com.example'
        
        ··· omit ···
        
    -   buildTypes {
    -       debug {
    -           firebaseCrashlytics {
    -               mappingFileUploadEnabled true
    -           }
    -           crashlytics {
    -               mappingFileUploadEnabled true
    -           }
    -       }
    -   }

    }
    
    dependencies {
    
    -   implementation platform('com.google.firebase:firebase-bom:26.8.0')
    -   implementation 'com.google.firebase:firebase-analytics'
    -   implementation 'com.google.firebase:firebase-crashlytics'
    -   implementation 'com.google.firebase:firebase-perf'
    
        ··· omit ···
    }
    ```