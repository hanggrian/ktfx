private const val VERSION_DOKKA = "0.10.0"

fun Dependencies.dokka(module: String? = null) =
    "org.jetbrains.dokka:dokka${module?.let { "-$it" }.orEmpty()}-gradle-plugin:$VERSION_DOKKA"

fun Plugins.dokka(module: String? = null) =
    id("org.jetbrains.dokka${module?.let { "-$it" }.orEmpty()}")
