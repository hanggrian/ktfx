@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.scene.control.ComboBox

inline fun <T> ComboBox<T>.converter(converter: StringConverterBuilder<T>.() -> Unit) = setConverter(converter.asConverter())