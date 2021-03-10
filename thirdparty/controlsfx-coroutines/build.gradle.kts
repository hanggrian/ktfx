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
    add(project(":rulesets:non-commons"))
}

dependencies {
    api(project(":$RELEASE_ARTIFACT-coroutines"))
    api(controlsfx())

    testImplementation(project(":testing:listeners-coroutines-controlsfx"))
}

tasks {
    dokkaHtml.configure {
        dokkaSourceSets {
            named("main") {
                displayName.set("$RELEASE_ARTIFACT-controlsfx-coroutines")
                sourceLink {
                    localDirectory.set(file("src"))
                    remoteUrl.set(github("thirdparty/controlsfx-coroutines"))
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
    artifactId = "$RELEASE_ARTIFACT-controlsfx-coroutines"
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}
