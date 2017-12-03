import org.gradle.kotlin.dsl.kotlin

plugins {
    java
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib", kotlinVersion))
    implementation(project(":kotfx"))
}