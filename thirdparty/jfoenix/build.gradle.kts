group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `maven-publish`
    signing
}

dependencies {
    implementation(project(":thirdparty:jfoenix-commons"))
    implementation(project(":thirdparty:jfoenix-layouts"))
    implementation(project(":thirdparty:jfoenix-listeners"))
    implementation(project(":thirdparty:jfoenix-coroutines"))
}

mavenPublishJvm("jfoenix")
