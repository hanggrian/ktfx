@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.SpinnerValueFactory

/** Converts the user-typed input. */
inline fun <T> SpinnerValueFactory<T>.converter(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setConverter(buildStringConverter(converter))
