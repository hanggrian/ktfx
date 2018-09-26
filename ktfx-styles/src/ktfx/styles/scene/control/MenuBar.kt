@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _MenuBarStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), MenuBarStyleBuilder {
    override var useSystemMenuBar: Boolean by map
}

interface MenuBarStyleBuilder {

    var useSystemMenuBar: Boolean
}

inline fun menuBarStyle(
    prettyPrint: Boolean = false,
    builder: MenuBarStyleBuilder .() -> Unit
): String = _MenuBarStyleBuilder(prettyPrint).apply(builder).toString()