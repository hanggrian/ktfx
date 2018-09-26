@file:Suppress("PackageDirectoryMismatch", "UsePropertyAccessSyntax")

/* ktlint-disable package-name */
package ktfx.listeners

/* ktlint-enable package-name */

import javafx.scene.chart.ValueAxis

/** StringConverter used to format tick mark labels. If null a default will be used. */
inline fun <T : Number> ValueAxis<T>.tickLabelFormatter(
    converter: StringConverterBuilder<T>.() -> Unit
) = setTickLabelFormatter(stringConverter(converter))