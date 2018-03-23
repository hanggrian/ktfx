package ktfx.styles

import javafx.scene.paint.Color

open class TextInputControlStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    @Incubating
    var font: String by map

    var textFill: Color by map

    var promptTextFill: Color by map

    var highlightFill: Color by map

    var highlightTextFill: Color by map

    var displayCaret: Boolean by map
}

inline fun textInputControlStyle(
    prettyPrint: Boolean = false,
    builder: TextInputControlStyleBuilder .() -> Unit
): String = TextInputControlStyleBuilder(prettyPrint).apply(builder).toString()