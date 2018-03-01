@file:Suppress("UsePropertyAccessSyntax")

package kotfx.scene

import javafx.scene.chart.ValueAxis
import kotfx.internal.asConverter
import kotfx.util.StringConverterBuilder

inline fun <T : Number> ValueAxis<T>.tickLabelFormatter(
    converter: StringConverterBuilder<T>.() -> Unit
) = setTickLabelFormatter(converter.asConverter())