@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.geometry.Orientation
import javafxx.styles.internal._ToolBarStyleBuilder

interface ToolBarStyleBuilder {

    var orientation: Orientation
}

inline fun toolBarStyle(
    prettyPrint: Boolean = false,
    builder: ToolBarStyleBuilder .() -> Unit
): String = _ToolBarStyleBuilder(prettyPrint).apply(builder).toString()