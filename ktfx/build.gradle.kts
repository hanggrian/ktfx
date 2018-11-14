group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `git-publish`
    bintray
    `bintray-release`
}

dependencies {
    compile(project(":$RELEASE_ARTIFACT-commons"))
    compile(project(":$RELEASE_ARTIFACT-coroutines"))
    compile(project(":$RELEASE_ARTIFACT-layouts"))
    compile(project(":$RELEASE_ARTIFACT-listeners"))
}

gitPublish {
    repoUri = RELEASE_WEB
    branch = "gh-pages"
    contents.from(
        "pages",
        *getKtfxArtifacts()
            .map { "../$it/build/docs" }
            .toTypedArray()
    )
}

tasks["gitPublishCopy"].dependsOn(
    *getKtfxArtifacts()
        .map { it.replace('/', ':') }
        .map { ":$it:dokka" }
        .toTypedArray()
)

fun getKtfxArtifacts(): List<String> =
    listOf("commons", "coroutines", "layouts", "listeners").map { "$RELEASE_ARTIFACT-$it" } +
        listOf("controlsfx", "jfoenix", "testfx").map { "$RELEASE_ARTIFACT-thirdparty/$it" }

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