@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.stage.Window
import javafx.stage.WindowEvent
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
 * @see Window.setOnCloseRequest
 */
public fun Window.onCloseRequest(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(WindowEvent) -> Unit): Unit = setOnCloseRequest { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Window.setOnShowing
 */
public fun Window.onShowing(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(WindowEvent) -> Unit): Unit = setOnShowing { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Window.setOnShown
 */
public fun Window.onShown(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(WindowEvent) -> Unit): Unit = setOnShown { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Window.setOnHiding
 */
public fun Window.onHiding(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(WindowEvent) -> Unit): Unit = setOnHiding { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Window.setOnHidden
 */
public fun Window.onHidden(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(WindowEvent) -> Unit): Unit = setOnHidden { event ->
        GlobalScope.launch(context) { action(event) } }
