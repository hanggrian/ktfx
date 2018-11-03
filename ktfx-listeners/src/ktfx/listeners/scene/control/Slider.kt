@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.Slider

/** A function for formatting the label for a major tick. */
inline fun Slider.labelFormatter(converter: StringConverterBuilder<Double>.() -> Unit) {
    labelFormatter = buildStringConverter(converter)
}