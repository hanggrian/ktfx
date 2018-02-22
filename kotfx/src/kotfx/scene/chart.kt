@file:JvmMultifileClass
@file:JvmName("ScenesKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx

import javafx.scene.chart.ValueAxis
import kotfx.internal.asConverter

fun <T : Number> ValueAxis<T>.tickLabelFormatter(
    converter: _StringConverter<T>.() -> Unit
) = setTickLabelFormatter(converter.asConverter())