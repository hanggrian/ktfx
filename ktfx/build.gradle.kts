group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `maven-publish`
    signing
}

dependencies {
    implementation(project(":$RELEASE_ARTIFACT-commons"))
    implementation(project(":$RELEASE_ARTIFACT-layouts"))
    implementation(project(":$RELEASE_ARTIFACT-listeners"))
    implementation(project(":$RELEASE_ARTIFACT-coroutines"))
}

mavenPublishJvm()
