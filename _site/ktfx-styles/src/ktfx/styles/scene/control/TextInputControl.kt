package ktfx.styles

import javafx.scene.paint.Color

interface TextInputControlStyleBuilder {

    @Incubating
    var font: String

    var textFill: Color

    var promptTextFill: Color

    var highlightFill: Color

    var highlightTextFill: Color

    var displayCaret: Boolean
}

@Suppress("ClassName")
open class _TextInputControlStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), TextInputControlStyleBuilder {
    override var font: String by map
    override var textFill: Color by map
    override var promptTextFill: Color by map
    override var highlightFill: Color by map
    override var highlightTextFill: Color by map
    override var displayCaret: Boolean by map
}

inline fun textInputControlStyle(
    prettyPrint: Boolean = false,
    builder: TextInputControlStyleBuilder .() -> Unit
): String = _TextInputControlStyleBuilder(prettyPrint).apply(builder).toString()