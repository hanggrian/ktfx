group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka
    `maven-publish`
    signing
}

sourceSets {
    main {
        java.srcDir("src")
    }
    test {
        java.srcDir("tests/src")
    }
}

ktlint(
    project(":rulesets:basic")
)

dependencies {
    api(project(":$RELEASE_ARTIFACT-commons"))
    api(controlsfx())
    testImplementation(project(":testing:commons"))
    testImplementation(project(":$RELEASE_ARTIFACT-layouts"))
    testImplementation(kotlinx("coroutines-javafx", VERSION_COROUTINES))
}

tasks {
    dokkaJavadoc {
        dokkaSourceSets {
            "main" {
                sourceLink {
                    localDirectory.set(projectDir.resolve("src"))
                    remoteUrl.set(getGithubRemoteUrl())
                    remoteLineSuffix.set("#L")
                }
            }
        }
    }
}

mavenPublishJvm("controlsfx-commons")