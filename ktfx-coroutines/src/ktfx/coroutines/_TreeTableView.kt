@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
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
 * @see TreeTableView.setOnSort
 */
fun <T> TreeTableView<T>.onSort(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SortEvent<TreeTableView<T>>) -> Unit
) {
    return setOnSort { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see TreeTableView.setOnScrollTo
 */
fun <T> TreeTableView<T>.onScrollTo(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollToEvent<Int>) -> Unit
) {
    return setOnScrollTo { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see TreeTableView.setOnScrollToColumn
 */
fun <T> TreeTableView<T>.onScrollToColumn(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<TreeTableColumn<T, *>>) -> Unit
) {
    return setOnScrollToColumn { event -> GlobalScope.launch(context) { action(event) } }
}
