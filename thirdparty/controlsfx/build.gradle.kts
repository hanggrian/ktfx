group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `maven-publish`
    signing
}

dependencies {
    api(project(":thirdparty:controlsfx-commons"))
    api(project(":thirdparty:controlsfx-layouts"))
    api(project(":thirdparty:controlsfx-listeners"))
    api(project(":thirdparty:controlsfx-coroutines"))
}

mavenPublishJvm("controlsfx")