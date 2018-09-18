import org.gradle.api.tasks.JavaExec
import org.jetbrains.dokka.gradle.DokkaTask
import org.gradle.language.base.plugins.LifecycleBasePlugin.*
import org.jetbrains.kotlin.gradle.dsl.Coroutines

group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `git-publish`
    bintray
    `bintray-release`
}

val artifacts: List<String> = ARTIFACTS - RELEASE_ARTIFACT

dependencies {
    artifacts.forEach { compile(project(":$it")) }
}

gitPublish {
    repoUri = RELEASE_WEB
    branch = "gh-pages"
    contents.from(
        "pages",
        *(artifacts + ARTIFACTS_THIRDPARTY).map { "../$it/build/docs" }.toTypedArray())
}

tasks["gitPublishCopy"].dependsOn(
    *(artifacts + ARTIFACTS_THIRDPARTY).map { ":$it:dokka" }.toTypedArray()
)

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