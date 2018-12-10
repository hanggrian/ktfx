rootDir.walkEach({ it.isDirectory && "ktfx" in it.name }) {
    when {
        "thirdparty" in it.name -> includeDir(it.name)
        else -> include(it.name)
    }
}

includeDir("ruleset")
includeDir("testing")
include("website")
include("demo")

fun includeDir(dir: String) = file(dir).walkEach { include("$dir:${it.name}") }

fun File.walkEach(
    filter: (File) -> Boolean = { it.isDirectory },
    forEach: (File) -> Unit
) = listFiles().filter(filter).forEach(forEach)