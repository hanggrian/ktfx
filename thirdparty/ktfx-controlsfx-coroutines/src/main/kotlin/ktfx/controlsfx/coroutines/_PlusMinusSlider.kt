@file:JvmMultifileClass
@file:JvmName("ControlsfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.coroutines

import kotlin.OptIn
import kotlin.Suppress
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.PlusMinusSlider

/**
 * @see PlusMinusSlider.setOnValueChanged
 */
public fun PlusMinusSlider.onValueChanged(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(PlusMinusSlider.PlusMinusEvent) -> Unit): Unit =
        setOnValueChanged { event -> GlobalScope.launch(context) { action(event) } }
