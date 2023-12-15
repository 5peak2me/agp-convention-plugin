
=== "build.gradle.kts"

    ```diff
    plugins {
    -   id("com.android.library")
    -   id("jacoco") // or id("org.gradle.jacoco")
    
    +   id("l3gacy.android.jacoco")
    }
    
    jacoco {
        toolVersion = "0.8.9"
        reportsDirectory = layout.buildDirectory.dir('customJacocoReportDir')
    }
    ```

=== "build.gradle"

    ```diff
    plugins {
    -   id 'com.android.library'
    -   id 'jacoco' // or id 'org.gradle.jacoco'
    
    +   id 'l3gacy.android.jacoco'
    }
    
    jacoco {
        toolVersion = "0.8.9"
        reportsDirectory = layout.buildDirectory.dir('customJacocoReportDir')
    }
    ```