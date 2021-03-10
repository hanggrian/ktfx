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
    api(project(":$RELEASE_ARTIFACT-commons"))
    api(jfoenix())

    testImplementation(project(":testing:commons"))
}

tasks {
    withType<KotlinCompile> { kotlinOptions.freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn") }
    dokkaHtml.configure {
        dokkaSourceSets {
            named("main") {
                displayName.set("$RELEASE_ARTIFACT-jfoenix-commons")
                sourceLink {
                    localDirectory.set(file("src"))
                    remoteUrl.set(github("thirdparty/jfoenix-commons"))
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
    artifactId = "$RELEASE_ARTIFACT-jfoenix-commons"
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}
