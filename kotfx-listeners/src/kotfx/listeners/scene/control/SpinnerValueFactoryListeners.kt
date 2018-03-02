@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.scene.control.SpinnerValueFactory
import kotfx.listeners.internal.asConverter

inline fun <T> SpinnerValueFactory<T>.converter(converter: StringConverterBuilder<T>.() -> Unit) = setConverter(converter.asConverter())