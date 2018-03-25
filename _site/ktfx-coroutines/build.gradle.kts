import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.dokka.gradle.DokkaTask
import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension
import org.jetbrains.kotlin.gradle.dsl.Coroutines.ENABLE
import org.gradle.language.base.plugins.LifecycleBasePlugin.*

group = "$releaseArtifact.coroutines"
version = releaseVersion

plugins {
    `java-library`
    kotlin("jvm")
    dokka
    `bintray-release`
    `junit-platform`
}

java.sourceSets {
    "main" { java.srcDir("src") }
    "test" { java.srcDir("tests/src") }
}

kotlin.experimental.coroutines = ENABLE

val ktlint by configurations.creating

dependencies {
    compile(project(":ktfx-commons"))
    compile(kotlin("stdlib", kotlinVersion))
    compile(kotlinx("coroutines-javafx", coroutinesVersion))

    testImplementation(kotlin("test", kotlinVersion))
    testImplementation(kotlin("reflect", kotlinVersion))
    testImplementation(junitPlatform("runner"))
    testImplementation(spek("api")) {
        exclude("org.jetbrains.kotlin")
    }
    testRuntime(spek("junit-platform-engine")) {
        exclude("org.jetbrains.kotlin")
        exclude("org.junit.platform")
    }
    testImplementation(testFX("core"))
    testImplementation(testFX("junit"))

    ktlint(ktlint())
}

tasks {
    "ktlint"(JavaExec::class) {
        get("check").dependsOn(this)
        group = VERIFICATION_GROUP
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
    repoName = releaseArtifact
    userOrg = releaseUser
    groupId = releaseGroup
    artifactId = "$releaseArtifact-coroutines"
    publishVersion = releaseVersion
    desc = releaseDesc
    website = releaseWeb
}

configure<JUnitPlatformExtension> {
    if (this is ExtensionAware) extensions.getByType(FiltersExtension::class.java).run {
        if (this is ExtensionAware) extensions.getByType(EnginesExtension::class.java).include("spek")
    }
}