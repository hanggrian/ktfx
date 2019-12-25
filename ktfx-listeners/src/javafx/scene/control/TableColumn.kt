@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.TableColumn

/** This event handler will be fired when the user successfully initiates editing. */
inline fun <S, T> TableColumn<S, T>.onEditStart(
    noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit
): Unit = setOnEditStart(action)

/** This event handler will be fired when the user successfully commits their editing. */
inline fun <S, T> TableColumn<S, T>.onEditCommit(
    noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit
): Unit = setOnEditCommit(action)

/** This event handler will be fired when the user cancels editing a cell. */
inline fun <S, T> TableColumn<S, T>.onEditCancel(
    noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit
): Unit = setOnEditCancel(action)
