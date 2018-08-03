@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.geometry.Orientation
import javafxx.styles.internal._SplitPaneStyleBuilder

interface SplitPaneStyleBuilder {

    var orientation: Orientation
}

inline fun splitPaneStyle(
    prettyPrint: Boolean = false,
    builder: SplitPaneStyleBuilder .() -> Unit
): String = _SplitPaneStyleBuilder(prettyPrint).apply(builder).toString()