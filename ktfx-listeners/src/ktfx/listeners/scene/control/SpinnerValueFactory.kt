@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

/* ktlint-disable package-name */
package ktfx.listeners

/* ktlint-enable package-name */

import javafx.scene.control.SpinnerValueFactory

/** Converts the user-typed input. */
inline fun <T> SpinnerValueFactory<T>.converter(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setConverter(stringConverter(converter))