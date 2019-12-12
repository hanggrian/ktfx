private const val VERSION_TESTFX = "4.0.16-alpha"
const val VERSION_JUNIT_JUPITER = "5.5.2"

fun Dependencies.testFx(module: String) = "org.testfx:testfx-$module:$VERSION_TESTFX"
fun Dependencies.junit(module: String, version: String) =
    "org.junit.${module.split('-').first()}:junit-$module:$version"