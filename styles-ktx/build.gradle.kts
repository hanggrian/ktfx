import org.gradle.api.tasks.JavaExec
import org.jetbrains.dokka.gradle.DokkaTask
import org.gradle.language.base.plugins.LifecycleBasePlugin.*
import org.jetbrains.kotlin.gradle.dsl.Coroutines

group = "$RELEASE_GROUP.styles"
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka
    bintray
    `bintray-release`
}

sourceSets {
    getByName("main") {
        java.srcDir("src")
    }
    getByName("test") {
        resources.srcDir("tests/res")
        java.srcDir("tests/src")
    }
}

val ktlint by configurations.registering

dependencies {
    compile(project(":$ARTIFACT_CORE"))
    compile(kotlin("stdlib", VERSION_KOTLIN))

    testImplementation(project(":testing"))
    testImplementation(kotlinx("coroutines-core", VERSION_COROUTINES))

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

    withType<DokkaTask> {
        outputDirectory = "$buildDir/docs"
        doFirst { file(outputDirectory).deleteRecursively() }
    }
}

publish {
    bintrayUser = BINTRAY_USER
    bintrayKey = BINTRAY_KEY
    dryRun = false
    repoName = RELEASE_ARTIFACT

    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = ARTIFACT_STYLES
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}