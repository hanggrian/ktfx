@file:JvmMultifileClass
@file:JvmName("ControlsfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.controlsfx.coroutines

import javafx.event.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.NotificationPane
import kotlin.coroutines.CoroutineContext

/**
 * @see NotificationPane.setOnShowing
 */
public fun NotificationPane.onShowing(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnShowing { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see NotificationPane.setOnShown
 */
public fun NotificationPane.onShown(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnShown { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see NotificationPane.setOnHiding
 */
public fun NotificationPane.onHiding(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnHiding { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see NotificationPane.setOnHidden
 */
public fun NotificationPane.onHidden(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnHidden { event ->
        GlobalScope.launch(context) { action(event) } }
