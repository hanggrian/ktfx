group = "$RELEASE_GROUP.coroutines"
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
}

kotlin.experimental.coroutines = org.jetbrains.kotlin.gradle.dsl.Coroutines.ENABLE

val ktlint by configurations.registering

dependencies {
    compile(project(":$ARTIFACT_CORE"))
    compile(kotlin("stdlib", VERSION_KOTLIN))
    compile(kotlinx("coroutines-javafx", VERSION_COROUTINES))

    testImplementation(project(":$ARTIFACT_DEV_TESTING"))

    ktlint {
        invoke(ktlint())
        invoke(project(":$ARTIFACT_DEV_RULESET_ALL"))
        invoke(project(":$ARTIFACT_DEV_RULESET_SINGLE_PACKAGE"))
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

    withType<org.jetbrains.dokka.gradle.DokkaTask> {
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
    artifactId = ARTIFACT_COROUTINES
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}