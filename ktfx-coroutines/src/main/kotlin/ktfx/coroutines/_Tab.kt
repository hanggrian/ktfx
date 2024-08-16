@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.event.Event
import javafx.scene.control.Tab
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
 * @see Tab.setOnSelectionChanged
 */
public fun Tab.onSelectionChanged(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnSelectionChanged { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Tab.setOnClosed
 */
public fun Tab.onClosed(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnClosed { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see Tab.setOnCloseRequest
 */
public fun Tab.onCloseRequest(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnCloseRequest { event ->
        GlobalScope.launch(context) { action(event) } }
