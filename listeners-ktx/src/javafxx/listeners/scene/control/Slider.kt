@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package javafxx.listeners

import javafx.scene.control.Slider

/** A function for formatting the label for a major tick. */
inline fun Slider.labelFormatter(
    converter: StringConverterBuilder<Double>.() -> Unit
) = setLabelFormatter(stringConverter(converter))