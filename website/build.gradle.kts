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
                "$RELEASE_ARTIFACT-features/$it-commons",
                "$RELEASE_ARTIFACT-features/$it-coroutines",
                "$RELEASE_ARTIFACT-features/$it-layouts",
                "$RELEASE_ARTIFACT-features/$it-listeners"
            )
        }