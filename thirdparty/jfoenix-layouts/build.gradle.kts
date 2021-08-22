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
    modules("javafx.controls")
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
    project(":rulesets:non-commons"),
    project(":rulesets:layouts")
)

dependencies {
    api(project(":$RELEASE_ARTIFACT-layouts"))
    api(jfoenix())
    testImplementation(project(":testing:layouts"))
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
        outputDirectory.set(buildDir.resolve("dokka/jfoenix-layouts"))
    }
}

mavenPublishJvm("jfoenix-layouts")