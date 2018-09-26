@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.scene.control.ScrollPane
import javafx.scene.control.ScrollPane.ScrollBarPolicy

@PublishedApi
internal class _ScrollPaneStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ScrollPaneStyleBuilder {
    override var fitToWidth: Boolean by map
    override var fitToHeight: Boolean by map
    override var pannable: Boolean by map
    override var hbarPolicy: ScrollPane.ScrollBarPolicy by map
    override var vbarPolicy: ScrollPane.ScrollBarPolicy by map
}

interface ScrollPaneStyleBuilder {

    var fitToWidth: Boolean

    var fitToHeight: Boolean

    var pannable: Boolean

    var hbarPolicy: ScrollBarPolicy

    var vbarPolicy: ScrollBarPolicy
}

inline fun scrollPaneStyle(
    prettyPrint: Boolean = false,
    builder: ScrollPaneStyleBuilder .() -> Unit
): String = _ScrollPaneStyleBuilder(prettyPrint).apply(builder).toString()