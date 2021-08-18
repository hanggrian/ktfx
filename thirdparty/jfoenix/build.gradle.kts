group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `maven-publish`
    signing
}

dependencies {
    api(project(":thirdparty:jfoenix-commons"))
    api(project(":thirdparty:jfoenix-layouts"))
    api(project(":thirdparty:jfoenix-listeners"))
    api(project(":thirdparty:jfoenix-coroutines"))
}

mavenPublishJvm("jfoenix")