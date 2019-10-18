plugins {
    `git-publish`
}

gitPublish {
    repoUri.set(RELEASE_WEB)
    branch.set("gh-pages")
    contents.from(
        "src",
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