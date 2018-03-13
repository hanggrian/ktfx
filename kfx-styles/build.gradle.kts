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

group = "$releaseArtifact.styles"
version = releaseVersion

plugins {
    `java-library`
    kotlin("jvm")
}

java.sourceSets {
    "main" { java.srcDir("src") }
    "test" {
        resources.srcDir("tests/res")
        java.srcDir("tests/src")
    }
}

val ktlint by configurations.creating

dependencies {
    compile(project(":kfx-commons"))
    compile(kotlin("stdlib", kotlinVersion))

    testImplementation(kotlinx("coroutines-core", coroutinesVersion))
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
        get("check").dependsOn(ktlint)
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
}