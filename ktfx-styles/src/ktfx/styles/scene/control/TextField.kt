package ktfx.styles

import javafx.geometry.Pos

class TextFieldStyleBuilder : TextInputControlStyleBuilder() {

    var alignment: Pos by map
}

inline fun textFieldStyle(builder: TextFieldStyleBuilder .() -> Unit): String =
    TextFieldStyleBuilder().apply(builder).toString()