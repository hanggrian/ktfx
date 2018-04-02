package ktfx.styles

import javafx.scene.paint.Color
import ktfx.styles.internal.NotImplemented
import ktfx.styles.internal._TextInputControlStyleBuilder

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