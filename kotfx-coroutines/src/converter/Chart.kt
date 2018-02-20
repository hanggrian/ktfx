@file:JvmMultifileClass
@file:JvmName("ConvertersKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx.coroutines

import javafx.scene.chart.ValueAxis
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlin.coroutines.experimental.CoroutineContext

fun <T : Number> ValueAxis<T>.tickLabelFormatter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setTickLabelFormatter(_StringConverter<T>(context).apply(converter))