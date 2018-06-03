import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.js.translate.context.Namer.kotlin
import org.jetbrains.dokka.gradle.DokkaTask

group = RELEASE_ARTIFACT
version = RELEASE_VERSION

plugins {
    `java-library`
    kotlin("jvm")
    `git-publish`
    `bintray-release`
}

val artifacts: List<String> = KTFX_ARTIFACTS - RELEASE_ARTIFACT

dependencies {
    artifacts.forEach { compile(project(":$it")) }
}

gitPublish {
    repoUri = RELEASE_WEB
    branch = "gh-pages"
    contents.from(
        "pages",
        *artifacts.map { "../$it/build/docs" }.toTypedArray(),
        *KTFX_THIRDPARTY_ARTIFACTS.map { "../${it.substringBeforeLast('-')}/thirdparty/${it.substringAfterLast('-')}/build/docs" }.toTypedArray())
}
tasks["gitPublishCopy"].dependsOn(
    *artifacts.map { ":$it:dokka" }.toTypedArray(),
    *KTFX_THIRDPARTY_ARTIFACTS.map { ":${it.substringBeforeLast('-')}:thirdparty:${it.substringAfterLast('-')}:dokka" }.toTypedArray()
)

publish {
    repoName = RELEASE_ARTIFACT
    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = RELEASE_ARTIFACT
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}