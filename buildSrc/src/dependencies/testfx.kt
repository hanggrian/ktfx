const val VERSION_TESTFX = "4.0.16-alpha"
const val VERSION_MONOCLE = "8u76-b04"
const val VERSION_JUNIT = "4.13-beta-3"

fun org.gradle.api.artifacts.dsl.DependencyHandler.testFx(module: String, version: String) =
    "org.testfx:$module:$version"

fun org.gradle.api.artifacts.dsl.DependencyHandler.junit() =
    "junit:junit:$VERSION_JUNIT"