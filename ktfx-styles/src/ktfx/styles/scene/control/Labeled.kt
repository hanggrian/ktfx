@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos
import javafx.scene.control.ContentDisplay
import javafx.scene.control.OverrunStyle
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import ktfx.geometry.Padding

open class _LabeledStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), LabeledStyleBuilder {
    override var alignment: Pos by map
    override var textAlignment: TextAlignment by map
    override var textOverrun: OverrunStyle by map
    override var wrapText: Boolean by map
    override var font: String by map
    override var underline: Boolean by map
    override var graphic: Url by map
    override var contentDisplay: ContentDisplay by map
    override var graphicTextGap: Number by map
    override var labelPadding: Padding by map
    override var textFill: Color by map
    override var ellipsisString: String by map
}

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

    var labelPadding: Padding

    var textFill: Color

    var ellipsisString: String
}

inline fun labeledStyle(
    prettyPrint: Boolean = false,
    builder: LabeledStyleBuilder .() -> Unit
): String = _LabeledStyleBuilder(prettyPrint).apply(builder).toString()