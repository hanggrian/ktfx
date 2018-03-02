@file:Suppress("UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.scene.chart.ValueAxis
import kotfx.listeners.internal.asConverter

inline fun <T : Number> ValueAxis<T>.tickLabelFormatter(
    converter: StringConverterBuilder<T>.() -> Unit
) = setTickLabelFormatter(converter.asConverter())