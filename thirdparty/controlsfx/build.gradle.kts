group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `maven-publish`
    signing
}

dependencies {
    implementation(project(":thirdparty:controlsfx-commons"))
    implementation(project(":thirdparty:controlsfx-layouts"))
    implementation(project(":thirdparty:controlsfx-listeners"))
    implementation(project(":thirdparty:controlsfx-coroutines"))
}

mavenPublishJvm("controlsfx")
