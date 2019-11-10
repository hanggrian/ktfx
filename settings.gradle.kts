include("ktfx")
include("ktfx-commons")
include("ktfx-core")
include("ktfx-coroutines")
include("ktfx-layouts")
include("ktfx-listeners")
include("ktfx-test")
includeDir("ktfx-features")

include("website")
include("demo")

includeDir("ruleset")
includeDir("testing")

fun includeDir(dir: String) = file(dir).walkEach { include("$dir:${it.name}") }

fun File.walkEach(
    filter: (File) -> Boolean = { it.isDirectory },
    forEach: (File) -> Unit
) = listFiles()?.filter(filter)?.forEach(forEach)