import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.gradle.dsl.Coroutines.*

plugins {
    java
    kotlin("jvm")
}

java.sourceSets["main"].java.srcDir("src")

kotlin.experimental.coroutines = ENABLE

dependencies {
    implementation(project(":ktfx"))
}