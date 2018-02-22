@file:JvmMultifileClass
@file:JvmName("UtilsKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx.coroutines

import javafx.scene.chart.ValueAxis
import kotlin.coroutines.experimental.CoroutineContext

fun <T : Number> ValueAxis<T>.tickLabelFormatter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setTickLabelFormatter(_StringConverter<T>(context).apply(converter))