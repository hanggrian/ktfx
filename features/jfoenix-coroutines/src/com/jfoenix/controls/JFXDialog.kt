@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Defines a function to be called when the dialog is closed. */
fun JFXDialog.onDialogClosed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXDialogEvent) -> Unit
): Unit = setOnDialogClosed { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when the dialog is opened. */
fun JFXDialog.onDialogOpened(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXDialogEvent) -> Unit
): Unit = setOnDialogOpened { event -> GlobalScope.launch(context) { action(event) } }
