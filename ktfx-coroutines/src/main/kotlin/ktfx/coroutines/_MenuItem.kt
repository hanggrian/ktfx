@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem
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
 * @see MenuItem.setOnAction
 */
public fun MenuItem.onAction(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ActionEvent) -> Unit): Unit = setOnAction { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see MenuItem.setOnMenuValidation
 */
public fun MenuItem.onMenuValidation(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnMenuValidation { event ->
        GlobalScope.launch(context) { action(event) } }
