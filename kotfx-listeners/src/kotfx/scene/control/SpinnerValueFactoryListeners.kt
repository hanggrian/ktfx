@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.scene.control.SpinnerValueFactory
import kotfx.internal.asConverter
import kotfx.util._StringConverter

inline fun <T> SpinnerValueFactory<T>.converter(
    converter: _StringConverter<T>.() -> Unit
) = setConverter(converter.asConverter())