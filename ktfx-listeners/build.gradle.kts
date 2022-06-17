group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    javafx
    kotlin("jvm")
    dokka
    `maven-publish`
    signing
}

javafx {
    modules("javafx.controls", "javafx.web")
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
    project(":rulesets:basic"),
    project(":rulesets:non-commons")
)

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(project(":testing:listeners-coroutines"))
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
    dokkaHtml {
        outputDirectory.set(buildDir.resolve("dokka/$RELEASE_ARTIFACT-listeners"))
    }
}

mavenPublishJvm("$RELEASE_ARTIFACT-listeners")
