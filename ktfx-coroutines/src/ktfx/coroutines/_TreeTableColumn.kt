@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.control.TreeTableColumn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see TreeTableColumn.setOnEditStart
 */
fun <S, T> TreeTableColumn<S, T>.onEditStart(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TreeTableColumn.CellEditEvent<S, T>) -> Unit
) {
    return setOnEditStart { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see TreeTableColumn.setOnEditCommit
 */
fun <S, T> TreeTableColumn<S, T>.onEditCommit(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TreeTableColumn.CellEditEvent<S, T>) -> Unit
) {
    return setOnEditCommit { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see TreeTableColumn.setOnEditCancel
 */
fun <S, T> TreeTableColumn<S, T>.onEditCancel(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TreeTableColumn.CellEditEvent<S, T>) -> Unit
) {
    return setOnEditCancel { event -> GlobalScope.launch(context) { action(event) } }
}
