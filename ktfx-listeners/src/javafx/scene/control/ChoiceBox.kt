@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import javafx.scene.control.ChoiceBox

/** Allows a way to specify how to represent objects in the items list. */
fun <T> ChoiceBox<T>.converter(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setConverter(buildStringConverter(converter))
