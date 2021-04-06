group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka
    `maven-publish`
    signing
}

dependencies {
    api(project(":thirdparty:controlsfx-commons"))
    api(project(":thirdparty:controlsfx-layouts"))
    api(project(":thirdparty:controlsfx-listeners"))
    api(project(":thirdparty:controlsfx-coroutines"))
}

tasks {
    dokkaJavadoc {
        dokkaSourceSets {
            "main" {
                sourceLink {
                    localDirectory.set(projectDir.resolve("src"))
                    remoteUrl.set(getReleaseSourceUrl())
                    remoteLineSuffix.set("#L")
                }
            }
        }
    }
    val javadocJar by registering(Jar::class) {
        archiveClassifier.set("javadoc")
        from(dokkaJavadoc)
        dependsOn(dokkaJavadoc)
    }
    val sourcesJar by registering(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }
}

publishJvm("$RELEASE_ARTIFACT-controlsfx")