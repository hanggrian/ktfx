plugins {
    javafx
    kotlin("jvm")
}

javafx {
    modules("javafx.controls", "javafx.web")
}

sourceSets {
    main {
        java.srcDir("src")
        resources.srcDir("res")
    }
}

dependencies {
    api(project(":testing:core"))
}