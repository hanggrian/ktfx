@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

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
