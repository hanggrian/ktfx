plugins {
    `git-publish`
}

gitPublish {
    repoUri.set("git@github.com:hendraanggrian/$RELEASE_ARTIFACT.git")
    branch.set("gh-pages")
    contents.from(
        "src",
        *ktfxArtifacts
            .map { "../$it/build/dokka" }
            .toTypedArray()
    )
}

tasks {
    register("clean") {
        delete(buildDir)
    }
    gitPublishCopy {
        dependsOn(
            *ktfxArtifacts
                .map { it.replace('/', ':') }
                .map { ":$it:dokkaHtml" }
                .toTypedArray()
        )
    }
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