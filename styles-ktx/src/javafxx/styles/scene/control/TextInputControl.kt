@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.scene.paint.Color
import javafxx.styles.internal.NotImplemented
import javafxx.styles.internal._TextInputControlStyleBuilder

interface TextInputControlStyleBuilder {

    @NotImplemented
    var font: String

    var textFill: Color

    var promptTextFill: Color

    var highlightFill: Color

    var highlightTextFill: Color

    var displayCaret: Boolean
}

inline fun textInputControlStyle(
    prettyPrint: Boolean = false,
    builder: TextInputControlStyleBuilder .() -> Unit
): String = _TextInputControlStyleBuilder(prettyPrint).apply(builder).toString()