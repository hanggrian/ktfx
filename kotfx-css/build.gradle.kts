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

group = "$releaseArtifact.css"
version = releaseVersion

plugins {
    `java-library`
    kotlin("jvm")
    dokka
    `bintray-release`
}

java.sourceSets {
    "main" { java.srcDir("src") }
    "test" { java.srcDir("tests/src") }
}

val ktlint by configurations.creating

dependencies {
    compile(project(":kotfx"))
    compile(kotlin("stdlib", kotlinVersion))
    ktlint(ktlint())
    testCompile("org.testfx:testfx-core:4.0.12-alpha")
    testCompile("org.testfx:testfx-junit:4.0.12-alpha")
    testCompile("junit:junit:4.12")
}

tasks {
    "ktlint"(JavaExec::class) {
        get("check").dependsOn(ktlint)
        group = "verification"
        inputs.dir("src")
        outputs.dir("src")
        description = "Check Kotlin code style."
        classpath = ktlint
        main = "com.github.shyiko.ktlint.Main"
        args("src/**/*.kt")
    }
    "ktlintFormat"(JavaExec::class) {
        group = "formatting"
        inputs.dir("src")
        outputs.dir("src")
        description = "Fix Kotlin code style deviations."
        classpath = ktlint
        main = "com.github.shyiko.ktlint.Main"
        args("-F", "src/**/*.kt")
    }

    withType<DokkaTask> {
        outputDirectory = "$buildDir/docs"
        doFirst { file(outputDirectory).deleteRecursively() }
    }
}

publish {
    userOrg = releaseUser
    groupId = releaseGroup
    artifactId = "$releaseArtifact-css"
    publishVersion = releaseVersion
    desc = releaseDesc
    website = releaseWeb
}