group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka
    `maven-publish`
    signing
}

sourceSets {
    getByName("main") {
        java.srcDir("src")
    }
    getByName("test") {
        java.srcDir("tests/src")
    }
}

dependencies {
    api(project(":$RELEASE_ARTIFACT-commons"))
    api(controlsfx())
    testImplementation(project(":testing:commons"))
    testImplementation(project(":$RELEASE_ARTIFACT-layouts"))
    testImplementation(kotlinx("coroutines-javafx", VERSION_COROUTINES))
}

ktlint { add ->
    add(project(":rulesets:basic"))
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
    val dokkaJar by registering(Jar::class) {
        archiveClassifier.set("javadoc")
        from(dokkaJavadoc)
        dependsOn(dokkaJavadoc)
    }
    val sourcesJar by registering(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }
}

publishJvm("$RELEASE_ARTIFACT-controlsfx-commons")