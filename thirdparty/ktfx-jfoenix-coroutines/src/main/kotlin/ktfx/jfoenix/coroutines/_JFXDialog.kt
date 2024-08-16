@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
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
 * @see JFXDialog.setOnDialogClosed
 */
public fun JFXDialog.onDialogClosed(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(JFXDialogEvent) -> Unit): Unit = setOnDialogClosed {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see JFXDialog.setOnDialogOpened
 */
public fun JFXDialog.onDialogOpened(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(JFXDialogEvent) -> Unit): Unit = setOnDialogOpened {
        event -> GlobalScope.launch(context) { action(event) } }
