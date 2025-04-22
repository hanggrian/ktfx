val releaseArtifact: String by project

plugins {
    alias(libs.plugins.javafx)
    application
    kotlin("jvm")
}

javafx.modules("javafx.controls")

application.mainClass.set("com.example.CalculatorApp")

dependencies {
    implementation(project(":$releaseArtifact-all"))
    implementation(project(":thirdparty:$releaseArtifact-controlsfx-all"))
    implementation(project(":thirdparty:$releaseArtifact-jfoenix-all"))
}
