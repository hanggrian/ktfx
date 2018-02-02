import org.gradle.kotlin.dsl.kotlin

plugins {
    java
    kotlin("jvm")
}

java.sourceSets {
    getByName("main").java.srcDir("src")
}

dependencies {
    implementation(kotlin("stdlib", kotlinVersion))
    implementation(project(":kotfx"))
}