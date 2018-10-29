group = "$RELEASE_GROUP.commons"
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

ktlint { add ->
    add(project(":$ARTIFACT_DEV_RULESET_ALL"))
}

dependencies {
    compile(project(":$ARTIFACT_CORE"))
    compile(kotlin("stdlib", VERSION_KOTLIN))

    testImplementation(project(":$ARTIFACT_DEV_TESTING_FX"))
    testImplementation(kotlinx("coroutines-javafx", VERSION_COROUTINES))
}

tasks {
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
    artifactId = ARTIFACT_COMMONS
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}