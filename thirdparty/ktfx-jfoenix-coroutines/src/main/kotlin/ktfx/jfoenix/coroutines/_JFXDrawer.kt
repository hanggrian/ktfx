@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
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
 * @see JFXDrawer.setOnDrawerClosed
 */
public fun JFXDrawer.onDrawerClosed(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(JFXDrawerEvent) -> Unit): Unit = setOnDrawerClosed {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see JFXDrawer.setOnDrawerClosing
 */
public fun JFXDrawer.onDrawerClosing(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(JFXDrawerEvent) -> Unit): Unit = setOnDrawerClosing {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see JFXDrawer.setOnDrawerOpened
 */
public fun JFXDrawer.onDrawerOpened(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(JFXDrawerEvent) -> Unit): Unit = setOnDrawerOpened {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see JFXDrawer.setOnDrawerOpening
 */
public fun JFXDrawer.onDrawerOpening(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(JFXDrawerEvent) -> Unit): Unit = setOnDrawerOpening {
        event -> GlobalScope.launch(context) { action(event) } }
