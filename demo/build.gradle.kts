import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.gradle.dsl.Coroutines.*

group = "$RELEASE_GROUP.demo"
version = RELEASE_VERSION

plugins {
    java
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

kotlin.experimental.coroutines = ENABLE

dependencies {
    implementation(project(":$RELEASE_ARTIFACT"))
    implementation(controlsFX())
}