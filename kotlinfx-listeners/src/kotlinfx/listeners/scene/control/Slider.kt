@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotlinfx.listeners

import javafx.scene.control.Slider

inline fun Slider.labelFormatter(
    converter: StringConverterBuilder<Double>.() -> Unit
) = setLabelFormatter(converter.build())