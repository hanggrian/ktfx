plugins {
    kotlin("jvm")
    application
}

application {
    mainClass.set("com.example.CalculatorApp")
}

sourceSets {
    main {
        java.srcDir("src")
    }
}

dependencies {
    implementation(project(":ktfx"))
    implementation(project(":thirdparty:controlsfx"))
    implementation(project(":thirdparty:jfoenix"))
}