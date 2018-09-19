@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

/* ktlint-disable package-name */
package javafxx.listeners

/* ktlint-enable package-name */

import javafx.scene.control.ComboBox

/** Converts the user-typed input. */
inline fun <T> ComboBox<T>.converter(
    converter: StringConverterBuilder<T>.() -> Unit
) = setConverter(stringConverter(converter))

/** Providing a custom cell factory allows for complete customization of the rendering of items in the ComboBox. */
inline fun <T> ComboBox<T>.cellFactory(
    noinline cellFactory: ListCellBuilder<T>.() -> Unit
) = setCellFactory { cellFactory.build() }