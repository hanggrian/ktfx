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
    api(jfoenix())
    testImplementation(project(":testing:commons"))
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }
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
        outputDirectory.set(buildDir.resolve("dokka/jfoenix-commons"))
    }
}

mavenPublishJvm("jfoenix-commons")