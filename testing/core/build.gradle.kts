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
    api(kotlin("stdlib", VERSION_KOTLIN))
    api(kotlin("test-junit", VERSION_KOTLIN))
    api(google("truth", "truth", VERSION_TRUTH))

    api(testFx("testfx-junit"))
    api(testFx("openjfx-monocle", VERSION_MONOCLE))
    api(junit())
}