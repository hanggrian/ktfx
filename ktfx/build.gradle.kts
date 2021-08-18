group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `maven-publish`
    signing
}

dependencies {
    api(project(":$RELEASE_ARTIFACT-commons"))
    api(project(":$RELEASE_ARTIFACT-layouts"))
    api(project(":$RELEASE_ARTIFACT-listeners"))
    api(project(":$RELEASE_ARTIFACT-coroutines"))
}

mavenPublishJvm()