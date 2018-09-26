@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos
import ktfx.styles.internal._TextFieldStyleBuilder

interface TextFieldStyleBuilder {

    var alignment: Pos
}

inline fun textFieldStyle(
    prettyPrint: Boolean = false,
    builder: TextFieldStyleBuilder .() -> Unit
): String = _TextFieldStyleBuilder(prettyPrint).apply(builder).toString()