@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.DatePicker
import java.time.LocalDate

/** Converts the input text to an object of type LocalDate and vice versa. */
inline fun DatePicker.converter(
    converter: StringConverterBuilder<LocalDate>.() -> Unit
): Unit = setConverter(stringConverter(converter))