@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import javafx.scene.control.DatePicker
import java.time.LocalDate

/** Converts the input text to an object of type LocalDate and vice versa. */
fun DatePicker.converter(
    converter: StringConverterBuilder<LocalDate>.() -> Unit
): Unit = setConverter(buildStringConverter(converter))
