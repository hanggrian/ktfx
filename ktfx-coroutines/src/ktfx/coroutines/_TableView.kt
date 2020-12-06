@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.Int
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see TableView.setOnSort
 */
public fun <S> TableView<S>.onSort(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SortEvent<TableView<S>>) -> Unit
) {
    return setOnSort { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see TableView.setOnScrollTo
 */
public fun <S> TableView<S>.onScrollTo(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) {
    return setOnScrollTo { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see TableView.setOnScrollToColumn
 */
public fun <S> TableView<S>.onScrollToColumn(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<TableColumn<S, *>>) -> Unit
) {
    return setOnScrollToColumn { event -> GlobalScope.launch(context) { action(event) } }
}
