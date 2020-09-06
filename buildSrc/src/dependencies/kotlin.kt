import org.gradle.api.Task
import java.net.URL

const val VERSION_KOTLIN = "1.4.0"
const val VERSION_COROUTINES = "1.3.9"

fun Dependencies.kotlinx(module: String, version: String? = null) =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$it" }.orEmpty()}"

fun Dependencies.dokka() = "org.jetbrains.dokka:dokka-gradle-plugin:$VERSION_KOTLIN"

val Plugins.dokka get() = id("org.jetbrains.dokka")

fun Task.github(path:String) = URL("https://github.com/hendraanggrian/ktfx/tree/master/$path/src")