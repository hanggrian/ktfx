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
    project(":rulesets:non-commons"),
    project(":rulesets:layouts")
)

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(project(":ktfx-commons"))
    testImplementation(project(":testing:layouts"))
    testImplementation(apache("commons-lang3", VERSION_COMMONS_LANG))
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
        outputDirectory.set(buildDir.resolve("dokka/$RELEASE_ARTIFACT-layouts"))
    }
}

mavenPublishJvm("$RELEASE_ARTIFACT-layouts")
