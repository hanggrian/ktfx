@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Orientation
import ktfx.styles.internal._ScrollBarStyleBuilder

interface ScrollBarStyleBuilder {

    var orientation: Orientation

    var blockIncrement: Number

    var unitIncrement: Number
}

inline fun scrollBarStyle(
    prettyPrint: Boolean = false,
    builder: ScrollBarStyleBuilder .() -> Unit
): String = _ScrollBarStyleBuilder(prettyPrint).apply(builder).toString()