import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

mavenPublishing.configure(KotlinJvm(JavadocJar.Dokka("dokkaJavadoc")))

dependencies {
    api(project(":thirdparty:controlsfx-commons"))
    api(project(":thirdparty:controlsfx-layouts"))
    api(project(":thirdparty:controlsfx-listeners"))
    api(project(":thirdparty:controlsfx-coroutines"))
}
