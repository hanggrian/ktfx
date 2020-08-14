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
    implementation(project(":features:controlsfx"))
    implementation(project(":features:jfoenix"))
}