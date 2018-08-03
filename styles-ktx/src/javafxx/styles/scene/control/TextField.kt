@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos
import javafxx.styles.internal._TextFieldStyleBuilder

interface TextFieldStyleBuilder {

    var alignment: Pos
}

inline fun textFieldStyle(
    prettyPrint: Boolean = false,
    builder: TextFieldStyleBuilder .() -> Unit
): String = _TextFieldStyleBuilder(prettyPrint).apply(builder).toString()