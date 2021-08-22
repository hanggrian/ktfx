plugins {
    javafx
    kotlin("jvm")
}

javafx {
    modules("javafx.controls")
}

sourceSets {
    main {
        java.srcDir("src")
        resources.srcDir("res")
    }
}

dependencies {
    api(project(":testing:listeners-coroutines"))
    api(controlsfx())
}