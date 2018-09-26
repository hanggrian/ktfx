@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos

@PublishedApi
internal class _TextFieldStyleBuilder(
    prettyPrint: Boolean
) : _TextInputControlStyleBuilder(prettyPrint), TextFieldStyleBuilder {
    override var alignment: Pos by map
}

interface TextFieldStyleBuilder {

    var alignment: Pos
}

inline fun textFieldStyle(
    prettyPrint: Boolean = false,
    builder: TextFieldStyleBuilder .() -> Unit
): String = _TextFieldStyleBuilder(prettyPrint).apply(builder).toString()