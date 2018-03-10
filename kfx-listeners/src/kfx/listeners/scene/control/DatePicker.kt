@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kfx.listeners

import javafx.scene.control.DatePicker
import java.time.LocalDate

inline fun DatePicker.converter(
    converter: StringConverterBuilder<LocalDate>.() -> Unit
) = setConverter(converter.build())