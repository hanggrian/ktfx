import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.maven.publish)
}

mavenPublishing.configure(KotlinJvm(JavadocJar.Dokka("dokkaJavadoc")))

dependencies {
    ktlint(libs.ktlint, ::configureKtlint)
    ktlint(libs.rulebook.ktlint)
    implementation(project(":$RELEASE_ARTIFACT-commons"))
    implementation(libs.controlsfx)
    testImplementation(project(":testing:commons"))
    testImplementation(project(":$RELEASE_ARTIFACT-layouts"))
    testImplementation(libs.kotlinx.coroutines.javafx)
}
