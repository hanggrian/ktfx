import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.kotlin

import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension

group = "$releaseGroup.$releaseArtifact"
version = releaseVersion

plugins {
    `java-library`
    kotlin("jvm")
    dokka
    `bintray-release`
    `junit-platform`
}

java.sourceSets {
    getByName("main").java.srcDir("src")
    getByName("test").java.srcDir("tests/src")
}

configurations.create("ktlint")

dependencies {
    compile(kotlin("stdlib", kotlinVersion))
    ktlint()
    testCompile(kotlin("test", kotlinVersion))
    testCompile(kotlin("reflect", kotlinVersion))
    testCompile(spek("api", spekVersion)) {
        exclude("org.jetbrains.kotlin")
    }
    testRuntime(spek("junit-platform-engine", spekVersion)) {
        exclude("org.jetbrains.kotlin")
        exclude("org.junit.platform")
    }
    testCompile(junitPlatform("runner", junitPlatformVersion))
}

task<JavaExec>("ktlint") {
    group = "verification"
    inputs.dir("src")
    outputs.dir("src")
    description = "Check Kotlin code style."
    classpath = configurations["ktlint"]
    main = "com.github.shyiko.ktlint.Main"
    args("src/**/*.kt")
}
tasks["check"].dependsOn(tasks["ktlint"])
task<JavaExec>("ktlintFormat") {
    group = "formatting"
    inputs.dir("src")
    outputs.dir("src")
    description = "Fix Kotlin code style deviations."
    classpath = configurations["ktlint"]
    main = "com.github.shyiko.ktlint.Main"
    args("-F", "src/**/*.kt")
}

publish {
    userOrg = releaseUser
    groupId = releaseGroup
    artifactId = releaseArtifact
    publishVersion = releaseVersion
    desc = releaseDesc
    website = releaseWeb
}

configure<JUnitPlatformExtension> {
    if (this is ExtensionAware) extensions.getByType(FiltersExtension::class.java).apply {
        if (this is ExtensionAware) extensions.getByType(EnginesExtension::class.java).include("spek")
    }
}