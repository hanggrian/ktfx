const val VERSION_KOTLIN = "1.3.61"
const val VERSION_COROUTINES = "1.3.3"

fun Dependencies.kotlinx(module: String, version: String? = null) =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$it" }.orEmpty()}"