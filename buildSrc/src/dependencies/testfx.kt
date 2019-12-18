const val VERSION_TESTFX = "4.0.16-alpha"
const val VERSION_MONOCLE = "8u76-b04"
const val VERSION_JUNIT_JUPITER = "5.5.2"

fun Dependencies.testFx(module: String, version: String) = "org.testfx:$module:$version"

fun Dependencies.junit(module: String, version: String) =
    "org.junit.${module.split('-').first()}:junit-$module:$version"