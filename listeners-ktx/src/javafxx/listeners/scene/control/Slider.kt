@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

/* ktlint-disable package-name */
package javafxx.listeners

/* ktlint-enable package-name */

import javafx.scene.control.Slider

/** A function for formatting the label for a major tick. */
inline fun Slider.labelFormatter(
    converter: StringConverterBuilder<Double>.() -> Unit
) = setLabelFormatter(stringConverter(converter))