@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Callback function to be informed when an item contained within this [ContextMenu] has been activated. */
fun ContextMenu.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> GlobalScope.launch(context) { action(event) } }
