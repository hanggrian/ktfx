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
    api(controlsfx())

    testImplementation(project(":testing:commons"))
    testImplementation(project(":$RELEASE_ARTIFACT-layouts"))
    testImplementation(kotlinx("coroutines-javafx", VERSION_COROUTINES))
}

tasks {
    dokkaHtml.configure {
        dokkaSourceSets {
            named("main") {
                moduleDisplayName.set("$RELEASE_ARTIFACT-controlsfx-commons")
                sourceLink {
                    localDirectory.set(file("src"))
                    remoteUrl.set(github("thirdparty/controlsfx-commons"))
                    remoteLineSuffix.set("#L")
                }
            }
        }
        doFirst { file(outputDirectory).deleteRecursively() }
    }
}

publishKotlinFix()
publish {
    bintrayUser = BINTRAY_USER
    bintrayKey = BINTRAY_KEY
    dryRun = false
    repoName = RELEASE_ARTIFACT

    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = "$RELEASE_ARTIFACT-controlsfx-commons"
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}
