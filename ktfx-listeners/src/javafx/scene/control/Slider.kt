@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import javafx.scene.control.Slider

/** A function for formatting the label for a major tick. */
fun Slider.labelFormatter(converter: StringConverterBuilder<Double>.() -> Unit) {
    labelFormatter = buildStringConverter(converter)
}
