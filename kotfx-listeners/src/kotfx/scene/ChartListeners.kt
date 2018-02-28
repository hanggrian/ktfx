@file:Suppress("UsePropertyAccessSyntax")

package kotfx.scene

import javafx.scene.chart.ValueAxis
import kotfx.util._StringConverter
import kotfx.internal.asConverter

inline fun <T : Number> ValueAxis<T>.tickLabelFormatter(
    converter: _StringConverter<T>.() -> Unit
) = setTickLabelFormatter(converter.asConverter())