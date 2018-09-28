import org.gradle.api.tasks.JavaExec
import org.jetbrains.dokka.gradle.DokkaTask
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
    get("main").java.srcDir("src")
    get("test").java.srcDir("tests/src")
    get("test").resources.srcDir("tests/res")
}

val ktlint by configurations.registering

dependencies {
    compile(project(":$ARTIFACT_COMMONS"))
    compile(kotlin("stdlib", VERSION_KOTLIN))

    testImplementation(project(":$ARTIFACT_DEV_TESTING"))
    testImplementation(kotlinx("coroutines-core", VERSION_COROUTINES))

    ktlint {
        invoke(ktlint())
        invoke(project(":$ARTIFACT_DEV_RULESET_BASE"))
        invoke(project(":$ARTIFACT_DEV_RULESET_EXTENDED"))
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