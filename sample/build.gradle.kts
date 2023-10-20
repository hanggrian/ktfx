val releaseArtifact: String by project

plugins {
    application
    kotlin("jvm")
}

application.mainClass.set("com.example.CalculatorApp")

dependencies {
    implementation(project(":$releaseArtifact"))
    implementation(project(":thirdparty:controlsfx"))
    implementation(project(":thirdparty:jfoenix"))
}
