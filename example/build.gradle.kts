import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.gradle.dsl.Coroutines.*

plugins {
    java
    kotlin("jvm")
}

java.sourceSets {
    getByName("main").java.srcDir("src")
}

kotlin.experimental.coroutines = ENABLE

dependencies {
    implementation(kotlin("stdlib", kotlinVersion))
    implementation(project(":kotfx"))
    implementation(project(":kotfx-layout"))
    implementation(project(":kotfx-coroutines"))
}