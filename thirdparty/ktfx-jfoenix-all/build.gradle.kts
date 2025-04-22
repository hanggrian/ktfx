val releaseArtifact: String by project

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

dependencies {
    api(project(":thirdparty:$releaseArtifact-jfoenix-commons"))
    api(project(":thirdparty:$releaseArtifact-jfoenix-layouts"))
    api(project(":thirdparty:$releaseArtifact-jfoenix-coroutines"))
}
