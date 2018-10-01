@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

/* ktlint-disable package-name */
package ktfx.listeners

/* ktlint-enable package-name */

import javafx.scene.control.DatePicker
import java.time.LocalDate

/** Converts the input text to an object of type LocalDate and vice versa. */
inline fun DatePicker.converter(
    converter: StringConverterBuilder<LocalDate>.() -> Unit
): Unit = setConverter(stringConverter(converter))