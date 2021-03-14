plugins {
    kotlin("jvm")
    application
}

application.mainClass.set("com.example.CalculatorApp")

sourceSets {
    getByName("main") {
        java.srcDir("src")
    }
}

dependencies {
    implementation(project(":ktfx"))
    implementation(project(":thirdparty:controlsfx"))
    implementation(project(":thirdparty:jfoenix"))
}