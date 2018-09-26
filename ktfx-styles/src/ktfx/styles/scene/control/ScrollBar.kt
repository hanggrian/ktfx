@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Orientation

@PublishedApi
internal class _ScrollBarStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ScrollBarStyleBuilder {
    override var orientation: Orientation by map
    override var blockIncrement: Number by map
    override var unitIncrement: Number by map
}

interface ScrollBarStyleBuilder {

    var orientation: Orientation

    var blockIncrement: Number

    var unitIncrement: Number
}

inline fun scrollBarStyle(
    prettyPrint: Boolean = false,
    builder: ScrollBarStyleBuilder .() -> Unit
): String = _ScrollBarStyleBuilder(prettyPrint).apply(builder).toString()