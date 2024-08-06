val releaseArtifact: String by project

plugins {
    alias(libs.plugins.javafx)
    application
    kotlin("jvm")
}

javafx.modules("javafx.controls")

application.mainClass.set("com.example.CalculatorApp")

dependencies {
    implementation(project(":$releaseArtifact"))
    implementation(project(":thirdparty:$releaseArtifact-controlsfx"))
    implementation(project(":thirdparty:$releaseArtifact-jfoenix"))
}
