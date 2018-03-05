@file:Suppress("UsePropertyAccessSyntax")

package kotlinfx.listeners

import javafx.scene.chart.ValueAxis

inline fun <T : Number> ValueAxis<T>.tickLabelFormatter(
    converter: StringConverterBuilder<T>.() -> Unit
) = setTickLabelFormatter(converter.build())