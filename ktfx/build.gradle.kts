import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.js.translate.context.Namer.kotlin
import org.jetbrains.dokka.gradle.DokkaTask
import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension

group = releaseArtifact
version = releaseVersion

plugins {
    `java-library`
    kotlin("jvm")
    `git-publish`
    `bintray-release`
}

val artifacts = arrayOf("commons", "coroutines", "layouts", "listeners", "styles").map { "ktfx-$it" }

dependencies {
    artifacts.forEach { compile(project(":$it")) }
}

gitPublish {
    repoUri = releaseWeb
    branch = "gh-pages"
    contents.from(*(arrayOf("pages") + artifacts.map { "../$it/build/docs" }))
}
tasks["gitPublishCopy"].dependsOn(*artifacts.map { ":$it:dokka" }.toTypedArray())

publish {
    repoName = releaseArtifact
    userOrg = releaseUser
    groupId = releaseGroup
    artifactId = releaseArtifact
    publishVersion = releaseVersion
    desc = releaseDesc
    website = releaseWeb
}