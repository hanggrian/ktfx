@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.scene.control.Slider
import kotfx.listeners.internal.asConverter

inline fun Slider.labelFormatter(converter: StringConverterBuilder<Double>.() -> Unit) = setLabelFormatter(converter.asConverter())