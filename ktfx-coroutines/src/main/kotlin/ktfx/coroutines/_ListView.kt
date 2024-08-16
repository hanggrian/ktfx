@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
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
 * @see ListView.setOnEditStart
 */
public fun <T> ListView<T>.onEditStart(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit): Unit = setOnEditStart {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see ListView.setOnEditCommit
 */
public fun <T> ListView<T>.onEditCommit(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit): Unit = setOnEditCommit {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see ListView.setOnEditCancel
 */
public fun <T> ListView<T>.onEditCancel(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit): Unit = setOnEditCancel {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see ListView.setOnScrollTo
 */
public fun <T> ListView<T>.onScrollTo(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit): Unit = setOnScrollTo {
        event -> GlobalScope.launch(context) { action(event) } }
