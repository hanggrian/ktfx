plugins {
    `git-publish`
}

gitPublish {
    repoUri.set(RELEASE_URL)
    branch.set("gh-pages")
    contents.from(
        "src",
        *ktfxArtifacts
            .map { "../$it/build/dokka/html" }
            .toTypedArray()
    )
}

tasks.gitPublishCopy {
    dependsOn(
        *ktfxArtifacts
            .map { it.replace('/', ':') }
            .map { ":$it:dokkaHtml" }
            .toTypedArray()
    )
}

val ktfxArtifacts: List<String>
    get() = listOf("commons", "layouts", "listeners", "coroutines").map { "$RELEASE_ARTIFACT-$it" } +
            listOf("controlsfx", "jfoenix").flatMap {
                listOf(
                    "thirdparty/$it-commons",
                    "thirdparty/$it-layouts",
                    "thirdparty/$it-listeners",
                    "thirdparty/$it-coroutines"
                )
            }