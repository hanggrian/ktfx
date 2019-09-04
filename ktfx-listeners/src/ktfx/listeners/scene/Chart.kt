@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.chart.ValueAxis

/** StringConverter used to format tick mark labels. If null a default will be used. */
inline fun <T : Number> ValueAxis<T>.tickLabelFormatter(
    noinline converter: StringConverterBuilder<T>.() -> Unit
): Unit = setTickLabelFormatter(buildStringConverter(converter))
