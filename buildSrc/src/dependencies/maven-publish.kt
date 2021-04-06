import org.gradle.api.provider.Provider
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.gradle.plugins.signing.Sign
import org.gradle.plugins.signing.SigningExtension

private val OSSRH_USERNAME get() = System.getenv("OSSRH_USERNAME")
private val OSSRH_PASSWORD get() = System.getenv("OSSRH_PASSWORD")

fun org.gradle.api.Project.publishJvm(artifact: String = RELEASE_ARTIFACT) =
    publish("java", artifact)

fun org.gradle.api.Project.publishAndroid(artifact: String = RELEASE_ARTIFACT) =
    afterEvaluate { publish("release", artifact) }

private fun org.gradle.api.Project.publish(component: String, artifact: String) {
    checkNotNull(tasks.findByName("javadocJar")) { "Missing task `javadocJar` for this publication" }
    checkNotNull(tasks.findByName("sourcesJar")) { "Missing task `sourcesJar` for this publication" }
    lateinit var mavenJava: Provider<MavenPublication>
    extensions.configure<PublishingExtension>("publishing") {
        repositories {
            maven {
                url = `java.net`.URI(if (isReleaseSnapshot()) REPO_OSSRH_SNAPSHOTS else REPO_OSSRH_RELEASES)
                credentials {
                    username = OSSRH_USERNAME
                    password = OSSRH_PASSWORD
                }
            }
        }
        publications {
            mavenJava = register<MavenPublication>("mavenJava") {
                groupId = RELEASE_GROUP
                artifactId = artifact
                version = RELEASE_VERSION
                from(components[component])
                artifact(tasks["javadocJar"])
                artifact(tasks["sourcesJar"])
                pom {
                    name.set(artifact)
                    description.set(RELEASE_DESCRIPTION)
                    url.set(RELEASE_URL)
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set(RELEASE_USER)
                            name.set("Hendra Anggrian")
                            email.set("hendraanggrian@gmail.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:$RELEASE_URL.git")
                        developerConnection.set("scm:git:$RELEASE_URL.git")
                        url.set(RELEASE_URL)
                    }
                }
            }
        }
    }
    extensions.configure<SigningExtension>("signing") {
        sign(mavenJava.get())
    }
    tasks.withType<Sign> {
        onlyIf { isReleaseSnapshot() }
    }
}

private fun isReleaseSnapshot() = RELEASE_VERSION.endsWith("SNAPSHOT")