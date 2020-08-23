plugins {
    kotlin("jvm")
    application
}

application.mainClassName = "com.example.CalculatorApp"

sourceSets {
    get("main").java.srcDir("src")
}

dependencies {
    implementation(project(":ktfx"))
    implementation(project(":thirdparty:controlsfx"))
    implementation(project(":thirdparty:jfoenix"))
}