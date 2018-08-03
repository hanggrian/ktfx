@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.ContentDisplay
import javafx.scene.control.OverrunStyle
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import javafxx.styles.internal.NotImplemented
import javafxx.styles.internal._LabeledStyleBuilder

interface LabeledStyleBuilder {

    var alignment: Pos

    /** Text-align from CSS spec maps to textAlignment in JavaFX. */
    var textAlignment: TextAlignment

    var textOverrun: OverrunStyle

    var wrapText: Boolean

    @NotImplemented
    var font: String

    var underline: Boolean

    var graphic: Url

    var contentDisplay: ContentDisplay

    var graphicTextGap: Number

    var labelPadding: Insets

    var textFill: Color

    var ellipsisString: String
}

inline fun labeledStyle(
    prettyPrint: Boolean = false,
    builder: LabeledStyleBuilder .() -> Unit
): String = _LabeledStyleBuilder(prettyPrint).apply(builder).toString()