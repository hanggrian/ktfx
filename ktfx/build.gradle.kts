group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka
    `maven-publish`
    signing
}

dependencies {
    api(project(":$RELEASE_ARTIFACT-commons"))
    api(project(":$RELEASE_ARTIFACT-layouts"))
    api(project(":$RELEASE_ARTIFACT-listeners"))
    api(project(":$RELEASE_ARTIFACT-coroutines"))
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

mavenPublishJvm()