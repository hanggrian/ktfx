@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

/* ktlint-disable package-name */
package javafxx.listeners

/* ktlint-enable package-name */

import javafx.scene.control.SpinnerValueFactory

/** Converts the user-typed input. */
inline fun <T> SpinnerValueFactory<T>.converter(
    converter: StringConverterBuilder<T>.() -> Unit
) = setConverter(stringConverter(converter))