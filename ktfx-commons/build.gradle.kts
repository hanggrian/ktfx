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

dependencies {
    api(kotlin("stdlib"))
    testImplementation(project(":testing:commons"))
    testImplementation(kotlinx("coroutines-javafx", VERSION_COROUTINES))
}

ktlint { add ->
    add(project(":rulesets:basic"))
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

publishJvm("$RELEASE_ARTIFACT-commons")