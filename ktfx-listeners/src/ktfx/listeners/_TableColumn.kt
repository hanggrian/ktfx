@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.TableColumn
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see TableColumn.setOnEditStart
 */
inline fun <S, T> TableColumn<S, T>.onEditStart(
    noinline action: (
        TableColumn.CellEditEvent<S,
            T>
    ) -> Unit
) {
    return setOnEditStart(action)
}

/**
 * @see TableColumn.setOnEditCommit
 */
inline fun <S, T> TableColumn<S, T>.onEditCommit(
    noinline action: (
        TableColumn.CellEditEvent<S,
            T>
    ) -> Unit
) {
    return setOnEditCommit(action)
}

/**
 * @see TableColumn.setOnEditCancel
 */
inline fun <S, T> TableColumn<S, T>.onEditCancel(
    noinline action: (
        TableColumn.CellEditEvent<S,
            T>
    ) -> Unit
) {
    return setOnEditCancel(action)
}
