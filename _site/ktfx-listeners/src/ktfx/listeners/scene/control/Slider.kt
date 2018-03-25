@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.listeners

import javafx.scene.control.Slider

inline fun Slider.labelFormatter(
    converter: StringConverterBuilder<Double>.() -> Unit
) = setLabelFormatter(converter.build())