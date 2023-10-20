val releaseArtifact: String by project

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

dependencies {
    api(project(":$releaseArtifact-commons"))
    api(project(":$releaseArtifact-layouts"))
    api(project(":$releaseArtifact-coroutines"))
}
