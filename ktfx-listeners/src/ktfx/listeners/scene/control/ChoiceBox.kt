@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.ChoiceBox

/** Allows a way to specify how to represent objects in the items list. */
inline fun <T> ChoiceBox<T>.converter(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setConverter(buildStringConverter(converter))
