@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _TableViewStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), TableViewStyleBuilder {
    override var size: Number by map
}

interface TableViewStyleBuilder {

    /** The table column header size. */
    var size: Number
}

inline fun tableViewStyle(
    prettyPrint: Boolean = false,
    builder: TableViewStyleBuilder .() -> Unit
): String = _TableViewStyleBuilder(prettyPrint).apply(builder).toString()