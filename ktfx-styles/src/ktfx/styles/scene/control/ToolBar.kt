@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Orientation

@PublishedApi
internal class _ToolBarStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ToolBarStyleBuilder {
    override var orientation: Orientation by map
}

interface ToolBarStyleBuilder {

    var orientation: Orientation
}

inline fun toolBarStyle(
    prettyPrint: Boolean = false,
    builder: ToolBarStyleBuilder .() -> Unit
): String = _ToolBarStyleBuilder(prettyPrint).apply(builder).toString()