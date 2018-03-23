package ktfx.styles

import javafx.geometry.Pos

class TextFieldStyleBuilder(prettyPrint: Boolean) : TextInputControlStyleBuilder(prettyPrint) {

    var alignment: Pos by map
}

inline fun textFieldStyle(
    prettyPrint: Boolean = false,
    builder: TextFieldStyleBuilder .() -> Unit
): String = TextFieldStyleBuilder(prettyPrint).apply(builder).toString()