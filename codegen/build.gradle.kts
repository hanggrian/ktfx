plugins {
    javafx
    kotlin("jvm")
    application
}

javafx {
    modules("javafx.base", "javafx.controls", "javafx.media", "javafx.web")
}

application {
    mainClass.set("$RELEASE_GROUP.$RELEASE_ARTIFACT.codegen.Generator")
}

sourceSets {
    main {
        java.srcDir("src")
    }
    test {
        java.srcDir("tests/src")
    }
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlin("reflect", VERSION_KOTLIN))
    implementation(kotlinx("coroutines-core", VERSION_COROUTINES))
    implementation(kotlinpoetKtx())
    implementation(controlsfx())
    implementation(jfoenix())
    testImplementation(kotlin("test-junit", VERSION_KOTLIN))
}