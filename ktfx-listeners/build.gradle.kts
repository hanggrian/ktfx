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
import org.gradle.language.base.plugins.LifecycleBasePlugin.*

group = ARTIFACT_LISTENERS.asGroup()
version = RELEASE_VERSION

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

val ktlint by configurations.creating

dependencies {
    compile(project(":$ARTIFACT_COMMONS"))
    compile(kotlin("stdlib", VERSION_KOTLIN))

    testImplementation(kotlin("test", VERSION_KOTLIN))
    testImplementation(kotlin("reflect", VERSION_KOTLIN))
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
    val ktlint by creating(JavaExec::class) {
        group = VERIFICATION_GROUP
        inputs.dir("src")
        outputs.dir("src")
        description = "Check Kotlin code style."
        classpath = configurations["ktlint"]
        main = "com.github.shyiko.ktlint.Main"
        args("src/**/*.kt")
    }
    get("check").dependsOn(ktlint)
    "ktlintFormat"(JavaExec::class) {
        group = "formatting"
        inputs.dir("src")
        outputs.dir("src")
        description = "Fix Kotlin code style deviations."
        classpath = configurations["ktlint"]
        main = "com.github.shyiko.ktlint.Main"
        args("-F", "src/**/*.kt")
    }

    withType<DokkaTask> {
        outputDirectory = "$buildDir/docs"
        doFirst { file(outputDirectory).deleteRecursively() }
    }
}

publish {
    repoName = RELEASE_ARTIFACT
    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = ARTIFACT_LISTENERS
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}

configure<JUnitPlatformExtension> {
    if (this is ExtensionAware) extensions.getByType(FiltersExtension::class.java).run {
        if (this is ExtensionAware) extensions.getByType(EnginesExtension::class.java).include("spek")
    }
}