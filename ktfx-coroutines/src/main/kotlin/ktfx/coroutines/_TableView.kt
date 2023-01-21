@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import kotlin.Int
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
 * @see TableView.setOnSort
 */
public fun <S> TableView<S>.onSort(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(SortEvent<TableView<S>>) -> Unit): Unit = setOnSort {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see TableView.setOnScrollTo
 */
public fun <S> TableView<S>.onScrollTo(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit): Unit = setOnScrollTo {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see TableView.setOnScrollToColumn
 */
public fun <S> TableView<S>.onScrollToColumn(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ScrollToEvent<TableColumn<S, *>>) -> Unit): Unit =
        setOnScrollToColumn { event -> GlobalScope.launch(context) { action(event) } }
