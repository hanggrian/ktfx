@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
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
 * @see Dialog.setOnShowing
 */
public fun Dialog<*>.onShowing(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(DialogEvent) -> Unit): Unit = setOnShowing { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Dialog.setOnShown
 */
public fun Dialog<*>.onShown(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(DialogEvent) -> Unit): Unit = setOnShown { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Dialog.setOnHiding
 */
public fun Dialog<*>.onHiding(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(DialogEvent) -> Unit): Unit = setOnHiding { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Dialog.setOnHidden
 */
public fun Dialog<*>.onHidden(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(DialogEvent) -> Unit): Unit = setOnHidden { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Dialog.setOnCloseRequest
 */
public fun Dialog<*>.onCloseRequest(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(DialogEvent) -> Unit): Unit = setOnCloseRequest { event ->
        GlobalScope.launch(context) { action(event) } }
