package ktfx.styles

import javafx.geometry.Pos
import ktfx.styles.internal._TextFieldStyleBuilder

interface TextFieldStyleBuilder {

    var alignment: Pos
}

inline fun textFieldStyle(
    prettyPrint: Boolean = false,
    builder: TextFieldStyleBuilder .() -> Unit
): String = _TextFieldStyleBuilder(prettyPrint).apply(builder).toString()