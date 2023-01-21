plugins {
    application
    kotlin("jvm")
}

application.mainClass.set("com.example.CalculatorApp")

dependencies {
    implementation(project(":$RELEASE_ARTIFACT"))
    implementation(project(":thirdparty:controlsfx"))
    implementation(project(":thirdparty:jfoenix"))
}
