plugins {
    `git-publish`
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