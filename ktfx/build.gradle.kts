import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

mavenPublishing.configure(KotlinJvm(JavadocJar.Dokka("dokkaJavadoc")))

dependencies {
    api(project(":$RELEASE_ARTIFACT-commons"))
    api(project(":$RELEASE_ARTIFACT-layouts"))
    api(project(":$RELEASE_ARTIFACT-listeners"))
    api(project(":$RELEASE_ARTIFACT-coroutines"))
}
