@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableColumn.CellEditEvent

/** This event handler will be fired when the user cancels editing a cell. */
inline fun <S, T> TreeTableColumn<S, T>.onEditCancel(
    noinline action: (CellEditEvent<S, T>) -> Unit
): Unit = setOnEditCancel { event -> action(event) }

/** This event handler will be fired when the user successfully commits their editing. */
inline fun <S, T> TreeTableColumn<S, T>.onEditCommit(
    noinline action: (CellEditEvent<S, T>) -> Unit
): Unit = setOnEditCommit { event -> action(event) }

/** This event handler will be fired when the user successfully initiates editing. */
inline fun <S, T> TreeTableColumn<S, T>.onEditStart(
    noinline action: (CellEditEvent<S, T>) -> Unit
): Unit = setOnEditStart { event -> action(event) }
