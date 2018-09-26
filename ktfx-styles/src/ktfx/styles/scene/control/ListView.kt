@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Orientation

@PublishedApi
internal class _ListViewStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ListViewStyleBuilder {
    override var orientation: Orientation by map
}

interface ListViewStyleBuilder {

    var orientation: Orientation
}

inline fun listViewStyle(
    prettyPrint: Boolean = false,
    builder: ListViewStyleBuilder .() -> Unit
): String = _ListViewStyleBuilder(prettyPrint).apply(builder).toString()