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
    compile(project(":kotfx-core"))
    compile(project(":kotfx-layouts"))
    compile(project(":kotfx-listeners"))
    compile(project(":kotfx-coroutines"))
}

tasks {
    gitPublish {
        repoUri = releaseWeb
        branch = "gh-pages"
        contents.from(
            "pages",
            "../kotfx-core/build/docs",
            "../kotfx-layouts/build/docs",
            "../kotfx-listeners/build/docs",
            "../kotfx-coroutines/build/docs"
        )
    }
}

publish {
    userOrg = releaseUser
    groupId = releaseGroup
    artifactId = releaseArtifact
    publishVersion = releaseVersion
    desc = releaseDesc
    website = releaseWeb
}