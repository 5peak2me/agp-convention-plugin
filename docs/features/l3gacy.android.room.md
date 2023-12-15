=== "build.gradle.kts"

    ```diff
    plugins {
    +   id("l3gacy.android.application") // or id("l3gacy.android.library")
    
    -   id("com.google.devtools.ksp")
    +   id("l3gacy.android.room")
    }
    
    android {
        namespace = "com.example"
    }
    
    -ksp {
    -    arg(RoomSchemaArgProvider(File(projectDir, "schemas")))
    -}
    
    dependencies {
    -   val room_version = "2.5.2"
    -   implementation("androidx.room:room-runtime:$room_version")
    -   ksp("androidx.room:room-compiler:$room_version")
    -   implementation("androidx.room:room-ktx:$room_version")
    
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
    +   id("l3gacy.android.application") // or id("l3gacy.android.library")
    
    -   id("com.google.devtools.ksp")
    +   id("l3gacy.android.room")
    }
    
    android {
        namespace = "com.example"
    }
    
    -ksp {
    -    arg(RoomSchemaArgProvider(File(projectDir, "schemas")))
    -}
    
    dependencies {
    -   val room_version = "2.5.2"
    -   implementation("androidx.room:room-runtime:$room_version")
    -   ksp("androidx.room:room-compiler:$room_version")
    -   implementation("androidx.room:room-ktx:$room_version")
    
        implementation("androidx.core:core-ktx:1.9.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    }
    ```