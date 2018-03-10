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

dependencies {
    compile(project(":kfx-commons"))
    compile(project(":kfx-coroutines"))
    compile(project(":kfx-layouts"))
    compile(project(":kfx-listeners"))
}

gitPublish {
    repoUri = releaseWeb
    branch = "gh-pages"
    contents.from(
        "pages",
        "../kfx-commons/build/docs",
        "../kfx-coroutines/build/docs",
        "../kfx-layouts/build/docs",
        "../kfx-listeners/build/docs"
    )
}

publish {
    repoName = releaseArtifact
    userOrg = releaseUser
    groupId = releaseGroup
    artifactId = releaseArtifact
    publishVersion = releaseVersion
    desc = releaseDesc
    website = releaseWeb
}