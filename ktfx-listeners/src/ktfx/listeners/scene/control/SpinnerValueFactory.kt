@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import javafx.scene.control.SpinnerValueFactory

/** Converts the user-typed input. */
fun <T> SpinnerValueFactory<T>.converter(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setConverter(buildStringConverter(converter))
