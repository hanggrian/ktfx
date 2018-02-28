@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.scene.control.DatePicker
import kotfx.internal.asConverter
import kotfx.util._StringConverter
import java.time.LocalDate

inline fun DatePicker.converter(
    converter: _StringConverter<LocalDate>.() -> Unit
) = setConverter(converter.asConverter())