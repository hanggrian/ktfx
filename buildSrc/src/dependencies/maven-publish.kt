import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType

fun org.gradle.api.Project.publishJvm(
    artifactId: String = RELEASE_ARTIFACT,
    vararg artifacts: org.gradle.api.Task = arrayOf(defaultJavadocJar, defaultSourcesJar)
) = publish("java", artifactId, artifacts)

fun org.gradle.api.Project.publishAndroid(
    artifactId: String = RELEASE_ARTIFACT,
    vararg artifacts: org.gradle.api.Task = arrayOf(defaultJavadocJar, defaultSourcesJar)
) = afterEvaluate { publish("release", artifactId, artifacts) }

private fun org.gradle.api.Project.publish(
    component: String,
    artifactId: String,
    artifacts: Array<out org.gradle.api.Task>
) {
    checkNotNull(plugins.findPlugin("maven-publish")) { "Missing plugin `maven-publish` for this publication" }
    checkNotNull(plugins.findPlugin("signing")) { "Missing plugin `signing` for this publication" }
    lateinit var mavenJava: org.gradle.api.provider.Provider<org.gradle.api.publish.maven.MavenPublication>
    extensions.configure<org.gradle.api.publish.PublishingExtension>("publishing") {
        repositories {
            maven {
                url = `java.net`.URI(
                    if (isReleaseSnapshot()) REPOSITORIES_OSSRH_SNAPSHOTS
                    else REPOSITORIES_OSSRH_RELEASES
                )
                credentials {
                    username = OSSRH_USERNAME
                    password = OSSRH_PASSWORD
                }
            }
        }
        publications {
            mavenJava = register<org.gradle.api.publish.maven.MavenPublication>("mavenJava") {
                groupId = RELEASE_GROUP
                setArtifactId(artifactId)
                version = RELEASE_VERSION
                from(components[component])
                artifacts.forEach { artifact(it) }
                pom {
                    name.set(artifactId)
                    description.set(RELEASE_DESCRIPTION)
                    url.set(RELEASE_GITHUB)
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("hendraanggrian")
                            name.set("Hendra Anggrian")
                            email.set("hendraanggrian@gmail.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:$RELEASE_GITHUB.git")
                        developerConnection.set("scm:git:$RELEASE_GITHUB.git")
                        url.set(RELEASE_GITHUB)
                    }
                }
            }
        }
    }
    extensions.configure<org.gradle.plugins.signing.SigningExtension>("signing") {
        sign(mavenJava.get())
    }
    tasks.withType<org.gradle.plugins.signing.Sign> {
        onlyIf { isReleaseSnapshot() }
    }
}

private val OSSRH_USERNAME get() = System.getenv("OSSRH_USERNAME")
private val OSSRH_PASSWORD get() = System.getenv("OSSRH_PASSWORD")

private val org.gradle.api.Project.defaultJavadocJar
    get() = checkNotNull(tasks.findByName("javadocJar")) { "Missing task `javadocJar` for this publication" }

private val org.gradle.api.Project.defaultSourcesJar
    get() = checkNotNull(tasks.findByName("sourcesJar")) { "Missing task `sourcesJar` for this publication" }

private fun isReleaseSnapshot() = RELEASE_VERSION.endsWith("SNAPSHOT")