@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.listeners

/* ktlint-enable package-name */

import javafx.scene.control.Slider

/** A function for formatting the label for a major tick. */
inline fun Slider.labelFormatter(converter: StringConverterBuilder<Double>.() -> Unit) {
    labelFormatter = stringConverter(converter)
}