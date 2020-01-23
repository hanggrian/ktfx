plugins {
    kotlin("jvm")
}

sourceSets {
    getByName("main") {
        java.srcDir("src")
        resources.srcDir("res")
    }
}

dependencies {
    api(project(":testing:listeners-coroutines"))
    api(jfoenix())
}