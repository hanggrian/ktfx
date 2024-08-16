@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDecorator
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

/**
 * @see JFXDecorator.setOnCloseButtonAction
 */
public fun JFXDecorator.onCloseButtonAction(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.() -> Unit): Unit = setOnCloseButtonAction {
        GlobalScope.launch(context) { action() } }
