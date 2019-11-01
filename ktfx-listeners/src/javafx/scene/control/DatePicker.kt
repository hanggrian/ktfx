@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import java.time.LocalDate
import javafx.scene.control.DatePicker

/** Converts the input text to an object of type LocalDate and vice versa. */
fun DatePicker.converter(
    converter: StringConverterBuilder<LocalDate>.() -> Unit
): Unit = setConverter(buildStringConverter(converter))
