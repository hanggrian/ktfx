@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.scene.control.ChoiceBox

inline fun <T> ChoiceBox<T>.converter(converter: StringConverterBuilder<T>.() -> Unit) = setConverter(converter.asConverter())