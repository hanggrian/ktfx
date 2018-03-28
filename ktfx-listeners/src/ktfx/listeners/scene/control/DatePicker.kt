@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.listeners

import javafx.scene.control.DatePicker
import java.time.LocalDate

/** Converts the input text to an object of type LocalDate and vice versa. */
inline fun DatePicker.converter(
    converter: StringConverterBuilder<LocalDate>.() -> Unit
) = setConverter(stringConverter(converter))