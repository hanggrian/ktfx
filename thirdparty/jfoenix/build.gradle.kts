group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `bintray-release`
}

dependencies {
    api(project(":thirdparty:jfoenix-commons"))
    api(project(":thirdparty:jfoenix-layouts"))
    api(project(":thirdparty:jfoenix-listeners"))
    api(project(":thirdparty:jfoenix-coroutines"))
}

publish {
    bintrayUser = BINTRAY_USER
    bintrayKey = BINTRAY_KEY
    dryRun = false
    repoName = RELEASE_ARTIFACT

    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = "$RELEASE_ARTIFACT-jfoenix"
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}
