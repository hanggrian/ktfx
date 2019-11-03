import javax.xml.ws.Endpoint.publish

group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `bintray-release`
}

dependencies {
    api(project(":$RELEASE_ARTIFACT-features:controlsfx-commons"))
    api(project(":$RELEASE_ARTIFACT-features:controlsfx-coroutines"))
    api(project(":$RELEASE_ARTIFACT-features:controlsfx-layouts"))
}

publishKotlinFix()
publish {
    bintrayUser = BINTRAY_USER
    bintrayKey = BINTRAY_KEY
    dryRun = false
    repoName = RELEASE_ARTIFACT

    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = "$RELEASE_ARTIFACT-controlsfx"
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}
