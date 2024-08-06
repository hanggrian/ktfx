val developerId: String by project
val developerName: String by project
val developerUrl: String by project
val releaseGroup: String by project
val releaseArtifact: String by project
val releaseVersion: String by project
val releaseDescription: String by project
val releaseUrl: String by project

plugins {
    alias(libs.plugins.javafx) apply false
    kotlin("jvm") version libs.versions.kotlin apply false
    kotlin("kapt") version libs.versions.kotlin apply false
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinx.kover) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.maven.publish) apply false
}

allprojects {
    group = releaseGroup
    version = releaseVersion
}

subprojects {
    plugins.withType<org.openjfx.gradle.JavaFXPlugin>().configureEach {
        the<org.openjfx.gradle.JavaFXOptions>()
            .version = "${libs.versions.jdk.get()}.0.9"
    }
    plugins.withType<org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper>().configureEach {
        the<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension>()
            .jvmToolchain(libs.versions.jdk.get().toInt())
    }
    plugins.withType<org.jlleitschuh.gradle.ktlint.KtlintPlugin>().configureEach {
        the<org.jlleitschuh.gradle.ktlint.KtlintExtension>()
            .version
            .set(libs.versions.ktlint.get())
    }
    plugins.withType<com.vanniktech.maven.publish.MavenPublishBasePlugin> {
        configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
            configure(
                com.vanniktech.maven.publish.KotlinJvm(
                    com.vanniktech.maven.publish.JavadocJar.Dokka("dokkaJavadoc"),
                )
            )
            publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL)
            signAllPublications()
            pom {
                name.set(project.name)
                description.set(releaseDescription)
                url.set(releaseUrl)
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set(developerId)
                        name.set(developerName)
                        url.set(developerUrl)
                    }
                }
                scm {
                    url.set(releaseUrl)
                    connection.set("scm:git:https://github.com/$developerId/$releaseArtifact.git")
                    developerConnection.set("scm:git:ssh://git@github.com/$developerId/$releaseArtifact.git")
                }
            }
        }
    }
}

tasks {
    register(LifecycleBasePlugin.CLEAN_TASK_NAME) {
        delete(layout.buildDirectory)
    }
    dokkaHtmlMultiModule {
        outputDirectory.set(layout.buildDirectory.dir("dokka/dokka/"))
    }
}
