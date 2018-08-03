@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.scene.control.ScrollPane.ScrollBarPolicy
import javafxx.styles.internal._ScrollPaneStyleBuilder

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