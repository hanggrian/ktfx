@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeView
import kotlin.Int
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
 * @see TreeView.setOnEditStart
 */
public fun <T> TreeView<T>.onEditStart(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(TreeView.EditEvent<T>) -> Unit): Unit = setOnEditStart {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see TreeView.setOnEditCommit
 */
public fun <T> TreeView<T>.onEditCommit(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(TreeView.EditEvent<T>) -> Unit): Unit = setOnEditCommit {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see TreeView.setOnEditCancel
 */
public fun <T> TreeView<T>.onEditCancel(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(TreeView.EditEvent<T>) -> Unit): Unit = setOnEditCancel {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see TreeView.setOnScrollTo
 */
public fun <T> TreeView<T>.onScrollTo(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit): Unit = setOnScrollTo {
        event -> GlobalScope.launch(context) { action(event) } }
