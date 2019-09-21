group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `bintray-release`
}

dependencies {
    compile(project(":$RELEASE_ARTIFACT-commons"))
    compile(project(":$RELEASE_ARTIFACT-coroutines"))
    compile(project(":$RELEASE_ARTIFACT-layouts"))
    compile(project(":$RELEASE_ARTIFACT-listeners"))
}

publishKotlinFix()
publish {
    bintrayUser = BINTRAY_USER
    bintrayKey = BINTRAY_KEY
    dryRun = false
    repoName = RELEASE_ARTIFACT

    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = RELEASE_ARTIFACT
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}
