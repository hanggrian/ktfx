package ktfx.styles

import javafx.geometry.Pos

interface TextFieldStyleBuilder {

    var alignment: Pos
}

@PublishedApi
@Suppress("ClassName")
internal class _TextFieldStyleBuilder(
    prettyPrint: Boolean
) : _TextInputControlStyleBuilder(prettyPrint), TextFieldStyleBuilder {
    override var alignment: Pos by map
}

inline fun textFieldStyle(
    prettyPrint: Boolean = false,
    builder: TextFieldStyleBuilder .() -> Unit
): String = _TextFieldStyleBuilder(prettyPrint).apply(builder).toString()