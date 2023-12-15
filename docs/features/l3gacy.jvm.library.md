=== "build.gradle.kts"

    ```diff
    plugins {
    -   id("org.jetbrains.kotlin.jvm") version '1.4.32'
    
    +   id("l3gacy.jvm.library") version '0.0.1'
        id("org.jetbrains.kotlin.plugin.serialization") version '1.4.32'
    }
    
    - java {
    -     sourceCompatibility = JavaVersion.VERSION_11
    -     targetCompatibility = JavaVersion.VERSION_11
    - }
    ```

=== "build.gradle"

    ```diff
    plugins {
    -   id 'org.jetbrains.kotlin.jvm' version '1.4.32'
    
    +   id 'l3gacy.jvm.library' version '0.0.1'
        id 'org.jetbrains.kotlin.plugin.serialization' version '1.4.32'
    }
    
    - java {
    -     sourceCompatibility = JavaVersion.VERSION_11
    -     targetCompatibility = JavaVersion.VERSION_11
    - }
    ```