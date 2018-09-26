@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _TabPaneStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), TabPaneStyleBuilder {
    override var tabMinWidth: Int by map
    override var tabMaxWidth: Int by map
    override var tabMinHeight: Int by map
    override var tabMaxHeight: Int by map
}

interface TabPaneStyleBuilder {

    var tabMinWidth: Int

    var tabMaxWidth: Int

    var tabMinHeight: Int

    var tabMaxHeight: Int
}

inline fun tabPaneStyle(
    prettyPrint: Boolean = false,
    builder: TabPaneStyleBuilder .() -> Unit
): String = _TabPaneStyleBuilder(prettyPrint).apply(builder).toString()