@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu
import kotlin.Suppress
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/**
 * @see ContextMenu.setOnAction
 */
public fun ContextMenu.onAction(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ActionEvent) -> Unit): Unit = setOnAction { event ->
        GlobalScope.launch(context) { action(event) } }
