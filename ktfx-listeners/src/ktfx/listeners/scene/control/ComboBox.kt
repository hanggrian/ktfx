@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.listeners

/* ktlint-enable package-name */

import javafx.scene.control.ComboBox

/** Converts the user-typed input. */
inline fun <T> ComboBox<T>.converter(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setConverter(stringConverter(converter))

/** Providing a custom cell factory allows for complete customization of the rendering of items in the ComboBox. */
inline fun <T> ComboBox<T>.cellFactory(
    noinline cellFactory: ListCellBuilder<T>.() -> Unit
): Unit = setCellFactory { cellFactory.build() }