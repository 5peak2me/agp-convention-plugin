// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.spotless)
    alias(libs.plugins.detekt) apply false
}
