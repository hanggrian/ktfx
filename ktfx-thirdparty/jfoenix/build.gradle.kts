group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `bintray-release`
}

dependencies {
    api(project(":$RELEASE_ARTIFACT-thirdparty:jfoenix-commons"))
    api(project(":$RELEASE_ARTIFACT-thirdparty:jfoenix-coroutines"))
    api(project(":$RELEASE_ARTIFACT-thirdparty:jfoenix-layouts"))
}

publishKotlinFix()
publish {
    bintrayUser = BINTRAY_USER
    bintrayKey = BINTRAY_KEY
    dryRun = false
    repoName = RELEASE_ARTIFACT

    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = "$RELEASE_ARTIFACT-thirdparty-jfoenix"
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}
