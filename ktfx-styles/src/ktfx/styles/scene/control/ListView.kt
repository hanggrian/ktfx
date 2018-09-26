@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Orientation
import ktfx.styles.internal._ListViewStyleBuilder

interface ListViewStyleBuilder {

    var orientation: Orientation
}

inline fun listViewStyle(
    prettyPrint: Boolean = false,
    builder: ListViewStyleBuilder .() -> Unit
): String = _ListViewStyleBuilder(prettyPrint).apply(builder).toString()