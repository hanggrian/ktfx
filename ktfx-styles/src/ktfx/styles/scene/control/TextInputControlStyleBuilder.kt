package ktfx.styles

import javafx.scene.paint.Color

open class TextInputControlStyleBuilder : ControlStyleBuilder(), TextFillableStyleBuilder {

    @Incubating
    var font: String by map

    override var textFill: Color by map

    var promptTextFill: Color by map

    var highlightFill: Color by map

    var highlightTextFill: Color by map

    var displayCaret: Boolean by map
}

inline fun textInputControlStyle(builder: TextInputControlStyleBuilder .() -> Unit): String =
    TextInputControlStyleBuilder().apply(builder).toString()