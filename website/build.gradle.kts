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
    listOf("commons", "coroutines", "layouts", "listeners", "test").map { "$RELEASE_ARTIFACT-$it" } +
        listOf("controlsfx", "jfoenix").flatMap {
            listOf(
                "$RELEASE_ARTIFACT-thirdparty/$it-commons",
                "$RELEASE_ARTIFACT-thirdparty/$it-coroutines",
                "$RELEASE_ARTIFACT-thirdparty/$it-layouts"
            )
        }