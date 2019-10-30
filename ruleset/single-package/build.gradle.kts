plugins {
    kotlin("jvm")
    idea
}

sourceSets {
    getByName("main") {
        java.srcDir("src")
        resources.srcDir("res")   
    }
    get("test").java.srcDir("tests/src")
}

dependencies {
    api(project(":ruleset:core"))

    testImplementation(project(":testing:ruleset"))
}