@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBoxBase
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
 * @see ComboBoxBase.setOnAction
 */
public fun ComboBoxBase<*>.onAction(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ActionEvent) -> Unit): Unit = setOnAction { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see ComboBoxBase.setOnShowing
 */
public fun ComboBoxBase<*>.onShowing(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnShowing { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see ComboBoxBase.setOnShown
 */
public fun ComboBoxBase<*>.onShown(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnShown { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see ComboBoxBase.setOnHiding
 */
public fun ComboBoxBase<*>.onHiding(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnHiding { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see ComboBoxBase.setOnHidden
 */
public fun ComboBoxBase<*>.onHidden(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(Event) -> Unit): Unit = setOnHidden { event ->
        GlobalScope.launch(context) { action(event) } }
