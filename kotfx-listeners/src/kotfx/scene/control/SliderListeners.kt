@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.scene.control.Slider
import kotfx.internal.asConverter
import kotfx.util._StringConverter

inline fun Slider.labelFormatter(
    converter: _StringConverter<Double>.() -> Unit
) = setLabelFormatter(converter.asConverter())