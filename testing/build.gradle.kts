import org.gradle.api.tasks.JavaExec
import org.jetbrains.dokka.gradle.DokkaTask
import org.gradle.language.base.plugins.LifecycleBasePlugin.*
import org.jetbrains.kotlin.gradle.dsl.Coroutines

group = "$RELEASE_GROUP.test"
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
}

sourceSets {
    getByName("main") {
        java.srcDir("src")
    }
}

val ktlint by configurations.registering

dependencies {
    compile(kotlin("stdlib", VERSION_KOTLIN))
    compile(kotlin("test", VERSION_KOTLIN))
    compile(testFX("core"))
    compile(testFX("junit"))
    compile(truth())
    compile(junit())

    ktlint(this, ktlint())
}

tasks {
    register("ktlint", JavaExec::class) {
        get("check").dependsOn(ktlint)
        group = VERIFICATION_GROUP
        inputs.dir("src")
        outputs.dir("src")
        description = "Check Kotlin code style."
        classpath(ktlint())
        main = "com.github.shyiko.ktlint.Main"
        args("src/**.kt")
    }
    register("ktlintformat", JavaExec::class) {
        group = "formatting"
        inputs.dir("src")
        outputs.dir("src")
        description = "Fix Kotlin code style deviations."
        classpath(ktlint())
        main = "com.github.shyiko.ktlint.Main"
        args("-F", "src*.kt")
    }
}