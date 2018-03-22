package ktfx.styles

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.ContentDisplay
import javafx.scene.control.OverrunStyle
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment

open class LabeledStyleBuilder : ControlStyleBuilder() {

    var alignment: Pos by map

    /** Text-align from CSS spec maps to textAlignment in JavaFX. */
    var textAlignment: TextAlignment by map

    var textOverrun: OverrunStyle by map

    var wrapText: Boolean by map

    @Incubating
    var font: String by map

    var underline: Boolean by map

    var graphic: Url by map

    var contentDisplay: ContentDisplay by map

    var graphicTextGap: Number by map

    var labelPadding: Insets by map

    var textFill: Color by map

    var ellipsisString: String by map
}

inline fun labeledStyle(builder: LabeledStyleBuilder .() -> Unit): String =
    LabeledStyleBuilder().apply(builder).toString()