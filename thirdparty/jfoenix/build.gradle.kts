group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka
    `maven-publish`
    signing
}

dependencies {
    api(project(":thirdparty:jfoenix-commons"))
    api(project(":thirdparty:jfoenix-layouts"))
    api(project(":thirdparty:jfoenix-listeners"))
    api(project(":thirdparty:jfoenix-coroutines"))
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

mavenPublishJvm("jfoenix", tasks["javadoc"])