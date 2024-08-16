@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
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
 * @see TreeTableView.setOnSort
 */
public fun <T> TreeTableView<T>.onSort(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(SortEvent<TreeTableView<T>>) -> Unit): Unit = setOnSort {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see TreeTableView.setOnScrollTo
 */
public fun <T> TreeTableView<T>.onScrollTo(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit): Unit = setOnScrollTo {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see TreeTableView.setOnScrollToColumn
 */
public fun <T> TreeTableView<T>.onScrollToColumn(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ScrollToEvent<TreeTableColumn<T, *>>) -> Unit): Unit =
        setOnScrollToColumn { event -> GlobalScope.launch(context) { action(event) } }
