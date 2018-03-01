@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.scene.control.Slider
import kotfx.internal.asConverter
import kotfx.util.StringConverterBuilder

inline fun Slider.labelFormatter(converter: StringConverterBuilder<Double>.() -> Unit) = setLabelFormatter(converter.asConverter())