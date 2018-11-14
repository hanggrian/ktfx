rootDir.walkEach({ it.isDirectory && "ktfx" in it.name }) {
    when {
        it.isDirectory -> includeDir(it.name)
        else -> include(it.name)
    }
}

includeDir("ruleset")
includeDir("testing")
include("demo")

fun includeDir(dir: String) = File(dir).walkEach { include("$dir:${it.name}") }

fun File.walkEach(
    filter: (File) -> Boolean = { it.isDirectory },
    forEach: (File) -> Unit
) = walk().filter(filter).forEach(forEach)