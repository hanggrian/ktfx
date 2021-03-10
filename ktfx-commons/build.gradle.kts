import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka
    `bintray-release`
}

sourceSets {
    get("main").java.srcDir("src")
    get("test").java.srcDir("tests/src")
}

ktlint { add ->
    add(project(":rulesets:basic"))
}

dependencies {
    api(kotlin("stdlib"))

    testImplementation(project(":testing:commons"))
    testImplementation(kotlinx("coroutines-javafx", VERSION_COROUTINES))
}

tasks {
    withType<KotlinCompile> { kotlinOptions.freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn") }
    dokkaHtml.configure {
        dokkaSourceSets {
            named("main") {
                displayName.set("$RELEASE_ARTIFACT-commons")
                sourceLink {
                    localDirectory.set(file("src"))
                    remoteUrl.set(github("ktfx-commons"))
                    remoteLineSuffix.set("#L")
                }
            }
        }
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
    artifactId = "$RELEASE_ARTIFACT-commons"
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}
