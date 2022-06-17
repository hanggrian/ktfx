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
    }
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlin("test-junit", VERSION_KOTLIN))
    implementation(google("truth", "truth", VERSION_TRUTH))

    implementation(testFx("testfx-junit"))
    implementation(testFx("openjfx-monocle", VERSION_MONOCLE))
    implementation(junit())
}
