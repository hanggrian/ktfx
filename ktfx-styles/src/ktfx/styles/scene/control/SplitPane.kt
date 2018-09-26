@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Orientation

@PublishedApi
internal class _SplitPaneStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), SplitPaneStyleBuilder {
    override var orientation: Orientation by map
}

interface SplitPaneStyleBuilder {

    var orientation: Orientation
}

inline fun splitPaneStyle(
    prettyPrint: Boolean = false,
    builder: SplitPaneStyleBuilder .() -> Unit
): String = _SplitPaneStyleBuilder(prettyPrint).apply(builder).toString()