import org.gradle.api.tasks.JavaExec
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.dsl.Coroutines

group = "$RELEASE_GROUP.test"
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
}

sourceSets.getByName("main") {
    java.srcDir("src")
}

val ktlint by configurations.registering

dependencies {
    compile(kotlin("stdlib", VERSION_KOTLIN))
    compile(kotlin("test", VERSION_KOTLIN))
    compile(testFx("core"))
    compile(testFx("junit"))
    compile(truth())
    compile(junit())

    ktlint {
        invoke(ktlint())
        invoke(project(":ruleset"))
    }
}

tasks {
    val ktlint by registering(JavaExec::class) {
        group = LifecycleBasePlugin.VERIFICATION_GROUP
        inputs.dir("src")
        outputs.dir("src")
        description = "Check Kotlin code style."
        classpath(configurations["ktlint"])
        main = "com.github.shyiko.ktlint.Main"
        args("src/**/*.kt")
    }
    "check" {
        dependsOn(ktlint)
    }
    register("ktlintFormat", JavaExec::class) {
        group = "formatting"
        inputs.dir("src")
        outputs.dir("src")
        description = "Fix Kotlin code style deviations."
        classpath(configurations["ktlint"])
        main = "com.github.shyiko.ktlint.Main"
        args("-F", "src/**/*.kt")
    }
}