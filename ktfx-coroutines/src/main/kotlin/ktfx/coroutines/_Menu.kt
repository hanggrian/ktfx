@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.event.Event
import javafx.scene.control.Menu
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
 * @see Menu.setOnShowing
 */
public fun Menu.onShowing(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnShowing { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Menu.setOnShown
 */
public fun Menu.onShown(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnShown { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Menu.setOnHiding
 */
public fun Menu.onHiding(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnHiding { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Menu.setOnHidden
 */
public fun Menu.onHidden(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnHidden { event ->
        GlobalScope.launch(context) { action(event) } }
