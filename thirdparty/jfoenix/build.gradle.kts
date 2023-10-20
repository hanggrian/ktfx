plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

dependencies {
    api(project(":thirdparty:jfoenix-commons"))
    api(project(":thirdparty:jfoenix-layouts"))
    api(project(":thirdparty:jfoenix-coroutines"))
}
